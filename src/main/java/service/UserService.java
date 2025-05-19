package service;

import data.model.ApplicationUser;
import data.repository.UserRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public ApplicationUser authenticate(String username, String password) {
        ApplicationUser user = userRepository.authenticate(username, password);
        if (user != null) {
            return user;
        }
        return null;
    }

    public ApplicationUser getUserByEmail(String username) {
        return userRepository.findByEmail(username);
    }
}
