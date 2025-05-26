package data.model.User;

import data.model.Ruolo;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.*;

@Entity
@Table(name = "Utenti")
@UserDefinition
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Email", length = 100)
    @Username
    private String email;

    @Column(name = "Password", length = 100, nullable = false)
    @Password
    private String password;

    @ManyToOne
    @JoinColumn(name = "IdRuolo")
    private Ruolo role;

    public ApplicationUser(String email, String password, Ruolo role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public ApplicationUser() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Roles
    public String getRole() {
        return role != null ? role.description : null;
    }

    public void setRole(Ruolo role) {
        this.role = role;
    }
}
