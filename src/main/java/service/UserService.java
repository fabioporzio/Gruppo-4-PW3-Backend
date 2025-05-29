package service;

import data.model.Ruolo;
import data.model.User.ApplicationUser;
import data.repository.RoleRepository;
import data.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import web.UserResource;
import web.model.CreateUserRequest;
import web.model.UserResponse;

import java.util.List;

@ApplicationScoped
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserResponse> getAllUsers() {
        List<ApplicationUser> users = userRepository.findAll().list();
        List<UserResponse> userResponses = new java.util.ArrayList<>();
        for (ApplicationUser user : users) {
            userResponses.add(toUserResponse(user));
        }
        return userResponses;
    }

    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        Ruolo ruoloEsistente = roleRepository.findById(request.getRole().getId());

        String hash = BcryptUtil.bcryptHash(request.getPassword());

        ApplicationUser user = new ApplicationUser(
                request.getEmail(),
                hash,
                ruoloEsistente
        );
        userRepository.persist(user);

        return toUserResponse(user);

    }

    @Transactional
    public boolean updateUser(int id, CreateUserRequest request) {
        Ruolo ruoloEsistente = roleRepository.findById(request.getRole().getId());

        System.out.println("Ruolo Esistente: " + ruoloEsistente);

        int modify = userRepository.update("UPDATE ApplicationUser u " +
                        "SET u.role = :role " +
                        "WHERE u.id = :id",
                Parameters.with("role", ruoloEsistente)
                        .and("id", id));
        return modify > 0;
    }

    public Integer getIdByUser(UserResponse user) {
        return userRepository.find(
                "SELECT p.idPersona FROM Person p JOIN ApplicationUser u ON p.mail = u.email WHERE u.email = :email",
                Parameters.with("email", user.getEmail())).project(Integer.class).firstResult();
    }

    public UserResponse authenticate(String username, String password) {
        ApplicationUser user = userRepository.authenticate(username, password);
        if (user != null) {
            return toUserResponse(user);
        }
        return null;
    }

    public UserResponse getUserByEmail(String username) {
        return toUserResponse(userRepository.findByEmail(username));
    }

    private static UserResponse toUserResponse(ApplicationUser user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
