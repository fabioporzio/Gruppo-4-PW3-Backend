package data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Ruolo")
public class Ruolo {

    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Descrizione")
    public String description;

    public Ruolo(int id, String descrizione) {
        this.id = id;
        this.description = descrizione;
    }

    public Ruolo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return description;
    }

    public void setDescrizione(String description) {
        this.description = description;
    }
}
