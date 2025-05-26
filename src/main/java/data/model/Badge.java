package data.model;

import data.model.Person.Person;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Badge")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdBadge")
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdPersona", nullable = false)
    private Person persona;

    @Column(name = "IdCategoria")
    private Integer idCategoria;

    @Column(name = "CodiceBadge", nullable = false)
    private int codiceBadge;

    @Column(name = "CodiceEsterno", columnDefinition = "nchar(10)")
    private String codiceEsterno;

    @Column(name = "Abilitata", nullable = false)
    private boolean abilitata;

    @Column(name = "DataInizio", nullable = false)
    private LocalDate dataInizio;

    @Column(name = "Datafine", nullable = false)
    private LocalDate dataFine;

    @Column(name = "ConScadenza", nullable = false)
    private boolean conScadenza;

    @Column(name = "Attivata")
    private Boolean attivata;

    @Column(name = "Eliminata", nullable = false)
    private boolean eliminata;

    @Column(name = "RegPresenza", columnDefinition = "nchar(100)")
    private String regPresenza;

    @Column(name = "DataRestituzione", nullable = false)
    private LocalDate dataRestituzione;

    @Column(name = "IdRestituzione")
    private Integer idRestituzione;

    @Column(name = "Apb", columnDefinition = "nchar(10)")
    private String apb;

    @Column(name = "Pin")
    private Integer pin;

    @Column(name = "ApbState", columnDefinition = "nchar(10)")
    private String apbState;

    @Column(name = "TipoBadge", length = 20, nullable = false)
    private String tipoBadge;

    @OneToMany(mappedBy = "badge")
    private List<BadgeAssignment> assegnazioni;

    public Badge() {}

    public Badge(Person persona, Integer idCategoria, int codiceBadge, String codiceEsterno, boolean abilitata, LocalDate dataInizio, LocalDate dataFine, boolean conScadenza, Boolean attivata, boolean eliminata, String regPresenza, LocalDate dataRestituzione, Integer idRestituzione, String apb, Integer pin, String apbState, String tipoBadge, List<BadgeAssignment> assegnazioni) {
        this.persona = persona;
        this.idCategoria = idCategoria;
        this.codiceBadge = codiceBadge;
        this.codiceEsterno = codiceEsterno;
        this.abilitata = abilitata;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.conScadenza = conScadenza;
        this.attivata = attivata;
        this.eliminata = eliminata;
        this.regPresenza = regPresenza;
        this.dataRestituzione = dataRestituzione;
        this.idRestituzione = idRestituzione;
        this.apb = apb;
        this.pin = pin;
        this.apbState = apbState;
        this.tipoBadge = tipoBadge;
        this.assegnazioni = assegnazioni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPersona() {
        return persona;
    }

    public void setPersona(Person persona) {
        this.persona = persona;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getCodiceBadge() {
        return codiceBadge;
    }

    public void setCodiceBadge(int codiceBadge) {
        this.codiceBadge = codiceBadge;
    }

    public String getCodiceEsterno() {
        return codiceEsterno;
    }

    public void setCodiceEsterno(String codiceEsterno) {
        this.codiceEsterno = codiceEsterno;
    }

    public boolean isAbilitata() {
        return abilitata;
    }

    public void setAbilitata(boolean abilitata) {
        this.abilitata = abilitata;
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

    public boolean isConScadenza() {
        return conScadenza;
    }

    public void setConScadenza(boolean conScadenza) {
        this.conScadenza = conScadenza;
    }

    public Boolean getAttivata() {
        return attivata;
    }

    public void setAttivata(Boolean attivata) {
        this.attivata = attivata;
    }

    public boolean isEliminata() {
        return eliminata;
    }

    public void setEliminata(boolean eliminata) {
        this.eliminata = eliminata;
    }

    public String getRegPresenza() {
        return regPresenza;
    }

    public void setRegPresenza(String regPresenza) {
        this.regPresenza = regPresenza;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    public Integer getIdRestituzione() {
        return idRestituzione;
    }

    public void setIdRestituzione(Integer idRestituzione) {
        this.idRestituzione = idRestituzione;
    }

    public String getApb() {
        return apb;
    }

    public void setApb(String apb) {
        this.apb = apb;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getApbState() {
        return apbState;
    }

    public void setApbState(String apbState) {
        this.apbState = apbState;
    }

    public String getTipoBadge() {
        return tipoBadge;
    }

    public void setTipoBadge(String tipoBadge) {
        this.tipoBadge = tipoBadge;
    }

    public List<BadgeAssignment> getAssegnazioni() {
        return assegnazioni;
    }

    public void setAssegnazioni(List<BadgeAssignment> assegnazioni) {
        this.assegnazioni = assegnazioni;
    }
}

