package data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Timbratrice")
public class BadgeReader  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Descrizione")
    private String descrizione;

    public BadgeReader() {}

    public BadgeReader(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
