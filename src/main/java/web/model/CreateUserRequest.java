package web.model;

import data.model.Ruolo;

public class CreateUserRequest {
    private String email;
    private String password;
    private Ruolo role;

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

    public Ruolo getRole() {
        return role;
    }

    public void setRole(Ruolo role) {
        this.role = role;
    }
}
