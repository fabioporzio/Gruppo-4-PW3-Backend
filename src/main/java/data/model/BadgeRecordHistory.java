package data.model;

import data.model.badgeRecord.BadgeRecordCompositePrimaryKey;

import java.time.LocalDate;
import java.time.LocalTime;

public class BadgeRecordHistory {

    private Integer idPersona;
    private String nome;
    private String cognome;
    private String azienda;
    private String email;
    private Integer idBadge;
    private Integer codiceBadge;
    private Integer idTimbratura;
    private LocalDate dataTimbratura;
    private LocalTime oraTimbratura;
    private Integer idTimbratrice;
    private String descrizioneTimbratrice;

    public BadgeRecordHistory(Integer idPersona, String nome, String cognome, String azienda, String email, Integer idBadge, Integer codiceBadge, Integer idTimbratura, LocalDate dataTimbratura, LocalTime oraTimbratura, Integer idTimbratrice, String descrizioneTimbratrice) {
        this.idPersona = idPersona;
        this.nome = nome;
        this.cognome = cognome;
        this.azienda = azienda;
        this.email = email;
        this.idBadge = idBadge;
        this.codiceBadge = codiceBadge;
        this.idTimbratura = idTimbratura;
        this.dataTimbratura = dataTimbratura;
        this.oraTimbratura = oraTimbratura;
        this.idTimbratrice = idTimbratrice;
        this.descrizioneTimbratrice = descrizioneTimbratrice;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
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

    public Integer getIdBadge() {
        return idBadge;
    }

    public void setIdBadge(Integer idBadge) {
        this.idBadge = idBadge;
    }

    public Integer getCodiceBadge() {
        return codiceBadge;
    }

    public void setCodiceBadge(Integer codiceBadge) {
        this.codiceBadge = codiceBadge;
    }

    public Integer getIdTimbratura() {
        return idTimbratura;
    }

    public void setIdTimbratura(Integer idTimbratura) {
        this.idTimbratura = idTimbratura;
    }

    public LocalDate getDataTimbratura() {
        return dataTimbratura;
    }

    public void setDataTimbratura(LocalDate dataTimbratura) {
        this.dataTimbratura = dataTimbratura;
    }

    public LocalTime getOraTimbratura() {
        return oraTimbratura;
    }

    public void setOraTimbratura(LocalTime oraTimbratura) {
        this.oraTimbratura = oraTimbratura;
    }

    public Integer getIdTimbratrice() {
        return idTimbratrice;
    }

    public void setIdTimbratrice(Integer idTimbratrice) {
        this.idTimbratrice = idTimbratrice;
    }

    public String getDescrizioneTimbratrice() {
        return descrizioneTimbratrice;
    }

    public void setDescrizioneTimbratrice(String descrizioneTimbratrice) {
        this.descrizioneTimbratrice = descrizioneTimbratrice;
    }
}
