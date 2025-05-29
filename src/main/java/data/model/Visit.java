package data.model;

import data.model.Person.Person;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Visite")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdVisita")
    private Integer id;

    @Column(name = "DataInizio", nullable = false)
    private LocalDate dataInizio;

    @Column(name = "DataFine", nullable = true)
    private LocalDate dataFine;

    @Column(name = "OraInizio", nullable = false)
    private LocalTime oraInizio;

    @Column(name = "OraFine", nullable = true)
    private LocalTime oraFine;

    @Column(name = "Motivo", columnDefinition = "text", nullable = false)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "IdPersonaVisitatore", nullable = false)
    private Person personaVisitatore;

    @ManyToOne
    @JoinColumn(name = "IdResponsabile", nullable = false)
    private Person responsabile;

    @Column(name = "FlagDPI", nullable = false)
    private boolean flagDPI;

    @ManyToOne
    @JoinColumn(name = "IdMaterialeInformatico", nullable = false)
    private ItProvision materialeInformatico;

    @Column(name = "Vincolo")
    private Boolean vincolo;

    @Column(name = "FlagAccessoConAutomezzo", nullable = false)
    private boolean flagAccessoConAutomezzo;

    public Visit() {}

    public Visit(LocalDate dataInizio, LocalDate dataFine, LocalTime oraInizio, LocalTime oraFine, String motivo, Person personaVisitatore, Person responsabile, boolean flagDPI, ItProvision materialeInformatico, Boolean vincolo, boolean flagAccessoConAutomezzo) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.motivo = motivo;
        this.personaVisitatore = personaVisitatore;
        this.responsabile = responsabile;
        this.flagDPI = flagDPI;
        this.materialeInformatico = materialeInformatico;
        this.vincolo = vincolo;
        this.flagAccessoConAutomezzo = flagAccessoConAutomezzo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }

    public LocalTime getOraFine() {
        return oraFine;
    }

    public void setOraFine(LocalTime oraFine) {
        this.oraFine = oraFine;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Person getPersonaVisitatore() {
        return personaVisitatore;
    }

    public void setPersonaVisitatore(Person personaVisitatore) {
        this.personaVisitatore = personaVisitatore;
    }

    public Person getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(Person responsabile) {
        this.responsabile = responsabile;
    }

    public boolean isFlagDPI() {
        return flagDPI;
    }

    public void setFlagDPI(boolean flagDPI) {
        this.flagDPI = flagDPI;
    }

    public ItProvision getMaterialeInformatico() {
        return materialeInformatico;
    }

    public void setMaterialeInformatico(ItProvision materialeInformatico) {
        this.materialeInformatico = materialeInformatico;
    }

    public Boolean getVincolo() {
        return vincolo;
    }

    public void setVincolo(Boolean vincolo) {
        this.vincolo = vincolo;
    }

    public boolean isFlagAccessoConAutomezzo() {
        return flagAccessoConAutomezzo;
    }

    public void setFlagAccessoConAutomezzo(boolean flagAccessoConAutomezzo) {
        this.flagAccessoConAutomezzo = flagAccessoConAutomezzo;
    }
}


