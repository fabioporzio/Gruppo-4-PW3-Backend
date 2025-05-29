package web.model.createPerson;

import data.model.Person.DocumentType;
import data.model.Ruolo;

import java.time.LocalDate;

public class CreatePersonResponse {

    private final int idPersona;
    private final String nome;
    private final String cognome;
    private final String diminutivo;
    private final String azienda;
    private final String indirizzo;
    private final String citta;
    private final String provincia;
    private final String nazione;
    private final String telefono;
    private final String cellulare;
    private final String fax;
    private final String pIva;
    private final String cf;
    private final String mail;
    private final Boolean foto;
    private final String luogoNascita;
    private final LocalDate dataNascita;
    private final DocumentType tipoDocumento;
    private final String numeroDocumento;
    private final LocalDate dataScadenzaDoc;
    private final int giorniScadenza;
    private final Boolean flagDocPrivacy;
    private final LocalDate dataConsegnaDocPrivacy;
    private final Ruolo ruolo;

    public CreatePersonResponse(int idPersona, String nome, String cognome, String diminutivo, String azienda, String indirizzo, String citta, String provincia, String nazione, String telefono, String cellulare, String fax, String pIva, String cf, String mail, Boolean foto, String luogoNascita, LocalDate dataNascita, DocumentType tipoDocumento, String numeroDocumento, LocalDate dataScadenzaDoc, int giorniScadenza, Boolean flagDocPrivacy, LocalDate dataConsegnaDocPrivacy, Ruolo ruolo) {
        this.idPersona = idPersona;
        this.nome = nome;
        this.cognome = cognome;
        this.diminutivo = diminutivo;
        this.azienda = azienda;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.provincia = provincia;
        this.nazione = nazione;
        this.telefono = telefono;
        this.cellulare = cellulare;
        this.fax = fax;
        this.pIva = pIva;
        this.cf = cf;
        this.mail = mail;
        this.foto = foto;
        this.luogoNascita = luogoNascita;
        this.dataNascita = dataNascita;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.dataScadenzaDoc = dataScadenzaDoc;
        this.giorniScadenza = giorniScadenza;
        this.flagDocPrivacy = flagDocPrivacy;
        this.dataConsegnaDocPrivacy = dataConsegnaDocPrivacy;
        this.ruolo = ruolo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public String getAzienda() {
        return azienda;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getNazione() {
        return nazione;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCellulare() {
        return cellulare;
    }

    public String getFax() {
        return fax;
    }

    public String getpIva() {
        return pIva;
    }

    public String getCf() {
        return cf;
    }

    public String getMail() {
        return mail;
    }

    public Boolean getFoto() {
        return foto;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public DocumentType getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public LocalDate getDataScadenzaDoc() {
        return dataScadenzaDoc;
    }

    public int getGiorniScadenza() {
        return giorniScadenza;
    }

    public Boolean getFlagDocPrivacy() {
        return flagDocPrivacy;
    }

    public LocalDate getDataConsegnaDocPrivacy() {
        return dataConsegnaDocPrivacy;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }
}
