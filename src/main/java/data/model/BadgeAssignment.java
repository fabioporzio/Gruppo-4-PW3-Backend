package data.model;

import data.model.Person.Person;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "AssegnazioneBadge")
public class BadgeAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int id;

    @ManyToOne
    @JoinColumn(name = "IdBadge", nullable = false)
    public Badge badge;

    @ManyToOne
    @JoinColumn(name = "IdPersona", nullable = false)
    public Person persona;

    @Column(name = "DataInizioEffettiva", nullable = false)
    public LocalDate dataInizioEffettiva;

    @Column(name = "DataFineEffettiva", nullable = false)
    public LocalDate dataFineEffettiva;

    public BadgeAssignment() {}

    public BadgeAssignment(Badge badge, Person persona, LocalDate dataInizioEffettiva, LocalDate dataFineEffettiva) {
        this.badge = badge;
        this.persona = persona;
        this.dataInizioEffettiva = dataInizioEffettiva;
        this.dataFineEffettiva = dataFineEffettiva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Person getPersona() {
        return persona;
    }

    public void setPersona(Person persona) {
        this.persona = persona;
    }

    public LocalDate getDataInizioEffettiva() {
        return dataInizioEffettiva;
    }

    public void setDataInizioEffettiva(LocalDate dataInizioEffettiva) {
        this.dataInizioEffettiva = dataInizioEffettiva;
    }

    public LocalDate getDataFineEffettiva() {
        return dataFineEffettiva;
    }

    public void setDataFineEffettiva(LocalDate dataFineEffettiva) {
        this.dataFineEffettiva = dataFineEffettiva;
    }
}

