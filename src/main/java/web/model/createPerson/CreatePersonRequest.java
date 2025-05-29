package web.model.createPerson;

import data.model.Person.DocumentType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CreatePersonRequest {
    private Integer idRuna;
    private String nome;
    private String cognome;
    private String diminutivo;
    private String azienda;
    private String indirizzo;
    private String citta;
    private String provincia;
    private String nazione;
    private String telefono;
    private String cellulare;
    private String fax;
    private String pIva;
    private String cf;
    private String mail;
    private Boolean foto;
    private LocalDate dataAssunzione;
    private Integer matricola;
    private Integer idFiliale;
    private Integer idMansione;
    private Integer idDeposito;
    private Integer idRiferimento;
    private Boolean visitatore;
    private Integer accessNumber;
    private Integer accessCount;
    private Integer accessUpdate;
    private String luogoNascita;
    private LocalDate dataNascita;
    private LocalDate dataScadCertificato;
    private Boolean preposto;
    private Boolean antincendio;
    private Boolean primoSoccorso;
    private DocumentType tipoDocumento;
    private String numeroDocumento;
    private LocalDate dataScadenzaDoc;
    private int giorniScadenza;
    private Boolean duvri;
    private Integer numCentriCosto;
    private Boolean flagDocPrivacy;
    private LocalDate dataConsegnaDocPrivacy;
    private int idRuolo;

    public CreatePersonRequest(Integer idRuna, String nome, String cognome, String diminutivo, String azienda, String indirizzo, String citta, String provincia, String nazione, String telefono, String cellulare, String fax, String pIva, String cf, String mail, Boolean foto, LocalDate dataAssunzione, Integer matricola, Integer idFiliale, Integer idMansione, Integer idDeposito, Integer idRiferimento, Boolean visitatore, Integer accessNumber, Integer accessCount, Integer accessUpdate, String luogoNascita, LocalDate dataNascita, LocalDate dataScadCertificato, Boolean preposto, Boolean antincendio, Boolean primoSoccorso, DocumentType tipoDocumento, String numeroDocumento, LocalDate dataScadenzaDoc, int giorniScadenza, Boolean duvri, Integer numCentriCosto, Boolean flagDocPrivacy, LocalDate dataConsegnaDocPrivacy, int idRuolo) {
        this.idRuna = idRuna;
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
        this.dataAssunzione = dataAssunzione;
        this.matricola = matricola;
        this.idFiliale = idFiliale;
        this.idMansione = idMansione;
        this.idDeposito = idDeposito;
        this.idRiferimento = idRiferimento;
        this.visitatore = visitatore;
        this.accessNumber = accessNumber;
        this.accessCount = accessCount;
        this.accessUpdate = accessUpdate;
        this.luogoNascita = luogoNascita;
        this.dataNascita = dataNascita;
        this.dataScadCertificato = dataScadCertificato;
        this.preposto = preposto;
        this.antincendio = antincendio;
        this.primoSoccorso = primoSoccorso;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.dataScadenzaDoc = dataScadenzaDoc;
        this.giorniScadenza = ChronoUnit.DAYS.between(LocalDate.now(), dataScadenzaDoc) > 0 ? (int) ChronoUnit.DAYS.between(LocalDate.now(), dataScadenzaDoc) : 0 ;
        this.duvri = duvri;
        this.numCentriCosto = numCentriCosto;
        this.flagDocPrivacy = flagDocPrivacy;
        this.dataConsegnaDocPrivacy = dataConsegnaDocPrivacy;
        this.idRuolo = idRuolo;
    }

    public Integer getIdRuna() {
        return idRuna;
    }

    public void setIdRuna(Integer idRuna) {
        this.idRuna = idRuna;
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

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getpIva() {
        return pIva;
    }

    public void setpIva(String pIva) {
        this.pIva = pIva;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getFoto() {
        return foto;
    }

    public void setFoto(Boolean foto) {
        this.foto = foto;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public Integer getIdFiliale() {
        return idFiliale;
    }

    public void setIdFiliale(Integer idFiliale) {
        this.idFiliale = idFiliale;
    }

    public Integer getIdMansione() {
        return idMansione;
    }

    public void setIdMansione(Integer idMansione) {
        this.idMansione = idMansione;
    }

    public Integer getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(Integer idDeposito) {
        this.idDeposito = idDeposito;
    }

    public Integer getIdRiferimento() {
        return idRiferimento;
    }

    public void setIdRiferimento(Integer idRiferimento) {
        this.idRiferimento = idRiferimento;
    }

    public Boolean getVisitatore() {
        return visitatore;
    }

    public void setVisitatore(Boolean visitatore) {
        this.visitatore = visitatore;
    }

    public Integer getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(Integer accessNumber) {
        this.accessNumber = accessNumber;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public Integer getAccessUpdate() {
        return accessUpdate;
    }

    public void setAccessUpdate(Integer accessUpdate) {
        this.accessUpdate = accessUpdate;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public LocalDate getDataScadCertificato() {
        return dataScadCertificato;
    }

    public void setDataScadCertificato(LocalDate dataScadCertificato) {
        this.dataScadCertificato = dataScadCertificato;
    }

    public Boolean getPreposto() {
        return preposto;
    }

    public void setPreposto(Boolean preposto) {
        this.preposto = preposto;
    }

    public Boolean getAntincendio() {
        return antincendio;
    }

    public void setAntincendio(Boolean antincendio) {
        this.antincendio = antincendio;
    }

    public Boolean getPrimoSoccorso() {
        return primoSoccorso;
    }

    public void setPrimoSoccorso(Boolean primoSoccorso) {
        this.primoSoccorso = primoSoccorso;
    }

    public DocumentType getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(DocumentType tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getDataScadenzaDoc() {
        return dataScadenzaDoc;
    }

    public void setDataScadenzaDoc(LocalDate dataScadenzaDoc) {
        this.dataScadenzaDoc = dataScadenzaDoc;
    }

    public int getGiorniScadenza() {
        return giorniScadenza;
    }

    public void setGiorniScadenza(int giorniScadenza) {
        this.giorniScadenza = ChronoUnit.DAYS.between(LocalDate.now(), dataScadenzaDoc) > 0 ? (int) ChronoUnit.DAYS.between(LocalDate.now(), dataScadenzaDoc) : 0 ;;
    }

    public Boolean getDuvri() {
        return duvri;
    }

    public void setDuvri(Boolean duvri) {
        this.duvri = duvri;
    }

    public Integer getNumCentriCosto() {
        return numCentriCosto;
    }

    public void setNumCentriCosto(Integer numCentriCosto) {
        this.numCentriCosto = numCentriCosto;
    }

    public Boolean getFlagDocPrivacy() {
        return flagDocPrivacy;
    }

    public void setFlagDocPrivacy(Boolean flagDocPrivacy) {
        this.flagDocPrivacy = flagDocPrivacy;
    }

    public LocalDate getDataConsegnaDocPrivacy() {
        return dataConsegnaDocPrivacy;
    }

    public void setDataConsegnaDocPrivacy(LocalDate dataConsegnaDocPrivacy) {
        this.dataConsegnaDocPrivacy = dataConsegnaDocPrivacy;
    }

    public int getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(int idRuolo) {
        this.idRuolo = idRuolo;
    }
}