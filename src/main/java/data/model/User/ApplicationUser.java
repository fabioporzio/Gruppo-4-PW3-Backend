package data.model.User;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
@UserDefinition
public class ApplicationUser {

    @Id
    @Column(name = "Email", length = 100)
    @Username
    private String email;

    @Column(name = "Password", nullable = false)
    @Password
    private String password;

    @Column(name = "Role", length = 100, nullable = false)
    @Roles
    private String role;

    public ApplicationUser(String email, String password, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role.name();
    }

    public ApplicationUser() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
