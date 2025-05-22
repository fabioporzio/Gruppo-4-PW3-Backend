package service;

import data.model.Ruolo;
import data.model.User.ApplicationUser;
import data.repository.RoleRepository;
import data.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import web.UserResource;
import web.model.CreateUserRequest;
import web.model.UserResponse;

@ApplicationScoped
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
                user.getPassword(),
                user.getRole()
        );
    }
}
