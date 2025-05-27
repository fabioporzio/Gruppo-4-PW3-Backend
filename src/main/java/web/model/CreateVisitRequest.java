package web.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateVisitRequest {
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private LocalTime oraInizio;
    private LocalTime oraFine;
    private String motivo;
    private String nomeVisitatore;
    private String cognomeVisitatore;
    private String emailResponsabileVisita;
    private boolean flagDPI;
    private int idMaterialeInformatico;
    private Boolean vincolo;
    private boolean flagAccessoConAutomezzo;

    public CreateVisitRequest(LocalDate dataInizio, LocalDate dataFine, LocalTime oraInizio, LocalTime oraFine, String motivo, String nomeVisitatore, String cognomeVisitatore, String emailResponsabileVisita, boolean flagDPI, int idMaterialeInformatico, Boolean vincolo, boolean flagAccessoConAutomezzo) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.motivo = motivo;
        this.nomeVisitatore = nomeVisitatore;
        this.cognomeVisitatore = cognomeVisitatore;
        this.emailResponsabileVisita = emailResponsabileVisita;
        this.flagDPI = flagDPI;
        this.idMaterialeInformatico = idMaterialeInformatico;
        this.vincolo = vincolo;
        this.flagAccessoConAutomezzo = flagAccessoConAutomezzo;
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

    public String getNomeVisitatore() {
        return nomeVisitatore;
    }

    public void setNomeVisitatore(String nomeVisitatore) {
        this.nomeVisitatore = nomeVisitatore;
    }

    public String getCognomeVisitatore() {
        return cognomeVisitatore;
    }

    public void setCognomeVisitatore(String cognomeVisitatore) {
        this.cognomeVisitatore = cognomeVisitatore;
    }

    public String getEmailResponsabileVisita() {
        return emailResponsabileVisita;
    }

    public void setEmailResponsabileVisita(String emailResponsabileVisita) {
        this.emailResponsabileVisita = emailResponsabileVisita;
    }

    public boolean isFlagDPI() {
        return flagDPI;
    }

    public void setFlagDPI(boolean flagDPI) {
        this.flagDPI = flagDPI;
    }

    public int getIdMaterialeInformatico() {
        return idMaterialeInformatico;
    }

    public void setIdMaterialeInformatico(int idMaterialeInformatico) {
        this.idMaterialeInformatico = idMaterialeInformatico;
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
