package web.model;

public class EmployeeContactListResponse {

    private final int idPersona;
    private final String nome;
    private final String cognome;
    private final String email;
    private final String telefono;
    private final String cellulare;

    public EmployeeContactListResponse(int idPersona, String nome, String cognome, String email, String telefono, String cellulare) {
        this.idPersona = idPersona;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.cellulare = cellulare;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCellulare() {
        return cellulare;
    }
}
