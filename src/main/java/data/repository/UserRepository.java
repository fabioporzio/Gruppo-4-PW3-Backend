package data.repository;

import data.model.User.ApplicationUser;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<ApplicationUser, Integer> {
    public ApplicationUser authenticate(String email, String password) {
        ApplicationUser applicationUser = findByEmail(email);
        if (applicationUser != null) {
            boolean matches = BcryptUtil.matches(password, applicationUser.getPassword());
            if (matches) {
                return applicationUser;
            } else {
                return null;
            }
        }
        return null;
    }

    public ApplicationUser findByEmail(String email) {
        return find(
                "SELECT u from ApplicationUser u where " +
                        "u.email = :email ",
                Parameters.with("email", email)
        ).firstResult();
    }
}
