package data.model.Person;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Persone")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPersona")
    private int idPersona;

    @Column(name = "IdRuna")
    private int idRuna;

    @Column(name = "Nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "Cognome", length = 100, nullable = false)
    private String cognome;

    @Column(name = "Diminutivo", length = 50)
    private String diminutivo;

    @Column(name = "Azienda", length = 100)
    private String azienda;

    @Column(name = "Indirizzo", length = 100, nullable = false)
    private String indirizzo;

    @Column(name = "Citta", length = 100, nullable = false)
    private String citta;

    @Column(name = "Provincia", length = 100, nullable = false)
    private String provincia;

    @Column(name = "Nazione", length = 100, nullable = false)
    private String nazione;

    @Column(name = "Telefono", length = 100)
    private String telefono;

    @Column(name = "Cellulare", length = 100, nullable = false)
    private String cellulare;

    @Column(name = "Fax", length = 100)
    private String fax;

    @Column(name = "pIva", length = 11)
    private String pIva;

    @Column(name = "CF", length = 16, nullable = false, unique = true)
    private String cf;

    @Column(name = "Mail", length = 50, nullable = false, unique = true)
    private String mail;

    @Column(name = "Foto")
    private boolean foto;

    @Column(name = "DataAssunzione", nullable = false)
    private LocalDate dataAssunzione;

    @Column(name = "Matricola")
    private int matricola;

    @Column(name = "IdFiliale")
    private int idFiliale;

    @Column(name = "IdMansione")
    private int idMansione;

    @Column(name = "IdDeposito")
    private int idDeposito;

    @Column(name = "IdRiferimento")
    private int idRiferimento;

    @Column(name = "Visitatore")
    private boolean visitatore;

    @Column(name = "AccessNumber")
    private int accessNumber;

    @Column(name = "AccessCount")
    private int accessCount;

    @Column(name = "AccessUpdate")
    private int accessUpdate;

    @Column(name = "LuogoNascita", length = 100, nullable = false)
    private String luogoNascita;

    @Column(name = "DataNascita", nullable = false)
    private LocalDate dataNascita;

    @Column(name = "DataScadCertificato")
    private LocalDate dataScadCertificato;

    @Column(name = "Preposto")
    private boolean preposto;

    @Column(name = "Antincendio")
    private boolean antincendio;

    @Column(name = "PrimoSoccorso")
    private boolean primoSoccorso;

    @Column(name = "TipoDocumento", length = 20, nullable = false)
    private String tipoDocumento;

    @Column(name = "NumeroDocumento", length = 100, nullable = false)
    private String numeroDocumento;

    @Column(name = "DataScadenzaDoc", nullable = false)
    private LocalDate dataScadenzaDoc;

    @Column(name = "GiorniScadenza", nullable = false)
    private int giorniScadenza;

    @Column(name = "Duvri")
    private boolean duvri;

    @Column(name = "NumCentriCosto")
    private int numCentriCosto;

    @Column(name = "FlagDocPrivacy", nullable = false)
    private boolean flagDocPrivacy;

    @Column(name = "DataConsegnaDocPrivacy", nullable = false)
    private LocalDate dataConsegnaDocPrivacy;

    public Person() {}

    public Person(int idRuna, String nome, String cognome, String diminutivo, String azienda, String indirizzo, String citta, String provincia, String nazione, String telefono, String cellulare, String fax, String pIva, String cf, String mail, boolean foto, LocalDate dataAssunzione, int matricola, int idFiliale, int idMansione, int idDeposito, int idRiferimento, boolean visitatore, int accessNumber, int accessCount, int accessUpdate, String luogoNascita, LocalDate dataNascita, LocalDate dataScadCertificato, boolean preposto, boolean antincendio, boolean primoSoccorso, DocumentType tipoDocumento, String numeroDocumento, LocalDate dataScadenzaDoc, int giorniScadenza, boolean duvri, int numCentriCosto, boolean flagDocPrivacy, LocalDate dataConsegnaDocPrivacy) {
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
        this.tipoDocumento = tipoDocumento.name();
        this.numeroDocumento = numeroDocumento;
        this.dataScadenzaDoc = dataScadenzaDoc;
        this.giorniScadenza = giorniScadenza;
        this.duvri = duvri;
        this.numCentriCosto = numCentriCosto;
        this.flagDocPrivacy = flagDocPrivacy;
        this.dataConsegnaDocPrivacy = dataConsegnaDocPrivacy;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdRuna() {
        return idRuna;
    }

    public void setIdRuna(int idRuna) {
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

    public boolean isFoto() {
        return foto;
    }

    public void setFoto(boolean foto) {
        this.foto = foto;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public int getIdFiliale() {
        return idFiliale;
    }

    public void setIdFiliale(int idFiliale) {
        this.idFiliale = idFiliale;
    }

    public int getIdMansione() {
        return idMansione;
    }

    public void setIdMansione(int idMansione) {
        this.idMansione = idMansione;
    }

    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }

    public int getIdRiferimento() {
        return idRiferimento;
    }

    public void setIdRiferimento(int idRiferimento) {
        this.idRiferimento = idRiferimento;
    }

    public boolean isVisitatore() {
        return visitatore;
    }

    public void setVisitatore(boolean visitatore) {
        this.visitatore = visitatore;
    }

    public int getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(int accessNumber) {
        this.accessNumber = accessNumber;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    public int getAccessUpdate() {
        return accessUpdate;
    }

    public void setAccessUpdate(int accessUpdate) {
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

    public boolean isPreposto() {
        return preposto;
    }

    public void setPreposto(boolean preposto) {
        this.preposto = preposto;
    }

    public boolean isAntincendio() {
        return antincendio;
    }

    public void setAntincendio(boolean antincendio) {
        this.antincendio = antincendio;
    }

    public boolean isPrimoSoccorso() {
        return primoSoccorso;
    }

    public void setPrimoSoccorso(boolean primoSoccorso) {
        this.primoSoccorso = primoSoccorso;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
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
        this.giorniScadenza = giorniScadenza;
    }

    public boolean isDuvri() {
        return duvri;
    }

    public void setDuvri(boolean duvri) {
        this.duvri = duvri;
    }

    public int getNumCentriCosto() {
        return numCentriCosto;
    }

    public void setNumCentriCosto(int numCentriCosto) {
        this.numCentriCosto = numCentriCosto;
    }

    public boolean isFlagDocPrivacy() {
        return flagDocPrivacy;
    }

    public void setFlagDocPrivacy(boolean flagDocPrivacy) {
        this.flagDocPrivacy = flagDocPrivacy;
    }

    public LocalDate getDataConsegnaDocPrivacy() {
        return dataConsegnaDocPrivacy;
    }

    public void setDataConsegnaDocPrivacy(LocalDate dataConsegnaDocPrivacy) {
        this.dataConsegnaDocPrivacy = dataConsegnaDocPrivacy;
    }
}