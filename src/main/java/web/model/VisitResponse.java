package web.model;

import data.model.ItProvision;
import data.model.Person.Person;

import java.time.LocalDate;
import java.time.LocalTime;

public class VisitResponse {

    private int id;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private LocalTime oraInizio;
    private LocalTime oraFine;
    private String motivo;
    private Person visitatore;
    private Person responsabile;
    private boolean flagDPI;
    private ItProvision materialeInformatico;
    private boolean accessoConAutomezzo;

    public VisitResponse(int id, LocalDate dataInizio, LocalDate dataFine, LocalTime oraInizio, LocalTime oraFine, String motivo, Person visitatore, Person responsabile, boolean flagDPI, ItProvision materialeInformatico, boolean accessoConAutomezzo) {
        this.id = id;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.motivo = motivo;
        this.visitatore = visitatore;
        this.responsabile = responsabile;
        this.flagDPI = flagDPI;
        this.materialeInformatico = materialeInformatico;
        this.accessoConAutomezzo = accessoConAutomezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Person getVisitatore() {
        return visitatore;
    }

    public void setVisitatore(Person visitatore) {
        this.visitatore = visitatore;
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

    public boolean isAccessoConAutomezzo() {
        return accessoConAutomezzo;
    }

    public void setAccessoConAutomezzo(boolean accessoConAutomezzo) {
        this.accessoConAutomezzo = accessoConAutomezzo;
    }
}
