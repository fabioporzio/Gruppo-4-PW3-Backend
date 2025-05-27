package web.model;

import data.model.BadgeAssignment;
import java.time.LocalDate;
import java.util.List;

public class CreateBadgeRequest {
    private int id;

    private Integer idPersona;

    private Integer idCategoria;

    private int codiceBadge;

    private String codiceEsterno;

    private boolean abilitata;

    private LocalDate dataInizio;

    private LocalDate dataFine;

    private boolean conScadenza;

    private Boolean attivata;

    private boolean eliminata;

    private String regPresenza;

    private LocalDate dataRestituzione;

    private Integer idRestituzione;

    private String apb;

    private Integer pin;
    private String apbState;

    private String tipoBadge;

    private List<BadgeAssignment> assegnazioni;

    public CreateBadgeRequest() {}

    public CreateBadgeRequest(Integer idPersona, Integer idCategoria, int codiceBadge, String codiceEsterno, boolean abilitata, LocalDate dataInizio, LocalDate dataFine, boolean conScadenza, Boolean attivata, boolean eliminata, String regPresenza, LocalDate dataRestituzione, Integer idRestituzione, String apb, Integer pin, String apbState, String tipoBadge, List<BadgeAssignment> assegnazioni) {
        this.idPersona = idPersona;
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

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setPersona(Integer idPersona) {
        this.idPersona = idPersona;
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
