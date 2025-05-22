package web.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BadgeRecordHistoryResponse {

    private int idPersona;
    private String nome;
    private String cognome;
    private String azienda;
    private String email;
    private int IdBadge;
    private int codiceBadge;
    private int idTimbrature;
    private LocalDate dataTimbratura;
    private LocalTime oraTimbrature;
    private int idTimbratrice;
    private String descrizioneTimbratrice;

    public BadgeRecordHistoryResponse(int idPersona, String nome, String cognome, String azienda, String email, int idBadge, int codiceBadge, int idTimbrature, LocalDate dataTimbratura, LocalTime oraTimbrature, int idTimbratrice, String descrizioneTimbratrice) {
        this.idPersona = idPersona;
        this.nome = nome;
        this.cognome = cognome;
        this.azienda = azienda;
        this.email = email;
        IdBadge = idBadge;
        this.codiceBadge = codiceBadge;
        this.idTimbrature = idTimbrature;
        this.dataTimbratura = dataTimbratura;
        this.oraTimbrature = oraTimbrature;
        this.idTimbratrice = idTimbratrice;
        this.descrizioneTimbratrice = descrizioneTimbratrice;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdBadge() {
        return IdBadge;
    }

    public void setIdBadge(int idBadge) {
        IdBadge = idBadge;
    }

    public int getCodiceBadge() {
        return codiceBadge;
    }

    public void setCodiceBadge(int codiceBadge) {
        this.codiceBadge = codiceBadge;
    }

    public int getIdTimbrature() {
        return idTimbrature;
    }

    public void setIdTimbrature(int idTimbrature) {
        this.idTimbrature = idTimbrature;
    }

    public LocalDate getDataTimbratura() {
        return dataTimbratura;
    }

    public void setDataTimbratura(LocalDate dataTimbratura) {
        this.dataTimbratura = dataTimbratura;
    }

    public LocalTime getOraTimbrature() {
        return oraTimbrature;
    }

    public void setOraTimbrature(LocalTime oraTimbrature) {
        this.oraTimbrature = oraTimbrature;
    }

    public int getIdTimbratrice() {
        return idTimbratrice;
    }

    public void setIdTimbratrice(int idTimbratrice) {
        this.idTimbratrice = idTimbratrice;
    }

    public String getDescrizioneTimbratrice() {
        return descrizioneTimbratrice;
    }

    public void setDescrizioneTimbratrice(String descrizioneTimbratrice) {
        this.descrizioneTimbratrice = descrizioneTimbratrice;
    }
}
