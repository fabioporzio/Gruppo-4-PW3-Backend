package data.repository;

import data.model.Person.Person;
import data.model.EmployeeContactList;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Context;

import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person, Integer> {

    @Context
    EntityManager em;

    public List<Person> findPeopleSMInCompany() {
        return getEntityManager().createNativeQuery(
                        "SELECT p.* FROM Timbrature t " +
                                "INNER JOIN Timbratrice te ON te.Id = t.IdTimbratrice " +
                                "INNER JOIN Badge b ON b.IdBadge = t.IdBadge " +
                                "INNER JOIN Persone p ON p.IdPersona = b.IdPersona " +
                                "WHERE te.Id = 1 AND t.DataTimbratura = CAST(GETDATE() AS DATE) AND b.TipoBadge = 'Dipendente'", Person.class)
                .getResultList();
    }

    public List<Person> findPeopleSMOutCompany() {
        return getEntityManager().createNativeQuery(
                        "SELECT p.* FROM Timbrature t " +
                                "INNER JOIN Timbratrice te ON te.Id = t.IdTimbratrice " +
                                "INNER JOIN Badge b ON b.IdBadge = t.IdBadge " +
                                "INNER JOIN Persone p ON p.IdPersona = b.IdPersona " +
                                "WHERE te.Id = 5 AND t.DataTimbratura = CAST(GETDATE() AS DATE) AND b.TipoBadge = 'Dipendente'", Person.class)
                .getResultList();
    }

    public List<Person> findPeopleLunchArea() {
        return getEntityManager().createNativeQuery(
                        "SELECT p.* FROM Timbrature t " +
                                "INNER JOIN Timbratrice te ON te.Id = t.IdTimbratrice " +
                                "INNER JOIN Badge b ON b.IdBadge = t.IdBadge " +
                                "INNER JOIN Persone p ON p.IdPersona = b.IdPersona " +
                                "WHERE te.Id = 2 AND t.DataTimbratura = CAST(GETDATE() AS DATE)", Person.class)
                .getResultList();
    }

    public List<Person> findPeopleCigarette() {
        return getEntityManager().createNativeQuery(
                        "SELECT p.* FROM Timbrature t " +
                                "INNER JOIN Timbratrice te ON te.Id = t.IdTimbratrice " +
                                "INNER JOIN Badge b ON b.IdBadge = t.IdBadge " +
                                "INNER JOIN Persone p ON p.IdPersona = b.IdPersona " +
                                "WHERE te.Id = 3 AND t.DataTimbratura = CAST(GETDATE() AS DATE)", Person.class)
                .getResultList();
    }

    public List<Person> findPeopleParking() {
        return getEntityManager().createNativeQuery(
                        "SELECT p.* FROM Timbrature t " +
                                "INNER JOIN Timbratrice te ON te.Id = t.IdTimbratrice " +
                                "INNER JOIN Badge b ON b.IdBadge = t.IdBadge " +
                                "INNER JOIN Persone p ON p.IdPersona = b.IdPersona " +
                                "WHERE te.Id = 4 AND t.DataTimbratura = CAST(GETDATE() AS DATE)", Person.class)
                .getResultList();
    }

    public List<Person> findVisitorInCompany() {
        return getEntityManager().createNativeQuery(
                        "SELECT p.* FROM Timbrature t " +
                                "INNER JOIN Timbratrice te ON te.Id = t.IdTimbratrice " +
                                "INNER JOIN Badge b ON b.IdBadge = t.IdBadge " +
                                "INNER JOIN Persone p ON p.IdPersona = b.IdPersona " +
                                "WHERE te.Id = 1 AND t.DataTimbratura = CAST(GETDATE() AS DATE) AND b.TipoBadge = 'Visitatore'", Person.class)
                .getResultList();
    }

    public List<Person> findVisitorOutCompany() {
        return getEntityManager().createNativeQuery(
                        "SELECT p.* FROM Timbrature t " +
                                "INNER JOIN Timbratrice te ON te.Id = t.IdTimbratrice " +
                                "INNER JOIN Badge b ON b.IdBadge = t.IdBadge " +
                                "INNER JOIN Persone p ON p.IdPersona = b.IdPersona " +
                                "WHERE te.Id = 5 AND t.DataTimbratura = CAST(GETDATE() AS DATE) AND b.TipoBadge = 'Visitatore'", Person.class)
                .getResultList();
    }

    public List<Person> findMainetanceInCompany() {
        return getEntityManager().createNativeQuery(
                        "SELECT p.* FROM Timbrature t " +
                                "INNER JOIN Timbratrice te ON te.Id = t.IdTimbratrice " +
                                "INNER JOIN Badge b ON b.IdBadge = t.IdBadge " +
                                "INNER JOIN Persone p ON p.IdPersona = b.IdPersona " +
                                "WHERE te.Id = 1 AND t.DataTimbratura = CAST(GETDATE() AS DATE) AND b.TipoBadge = 'Manutentore'", Person.class)
                .getResultList();
    }

    public List<Person> findMainetanceOutCompany() {
        return getEntityManager().createNativeQuery(
                        "SELECT p.* FROM Timbrature t " +
                                "INNER JOIN Timbratrice te ON te.Id = t.IdTimbratrice " +
                                "INNER JOIN Badge b ON b.IdBadge = t.IdBadge " +
                                "INNER JOIN Persone p ON p.IdPersona = b.IdPersona " +
                                "WHERE te.Id = 5 AND t.DataTimbratura = CAST(GETDATE() AS DATE) AND b.TipoBadge = 'Manutentore'", Person.class)
                .getResultList();
    }

    public Person findByEmail(String email) {
        return find("SELECT p FROM Person p  WHERE p.mail = :mail",
                Parameters.with("mail", email)).firstResult();
    }

    public Person findByNameAndSurname(String name, String surname) {
        return find("SELECT p FROM Person p  WHERE p.nome = :name AND p.cognome = :surname",
                Parameters.with("name", name).and("surname", surname)).firstResult();
    }

    @Transactional
    public boolean updatePersonData(Person person, int idPersona) {
        int update = update("UPDATE Person p " +
                        "SET p.idRuna = :idRuna, p.nome = :nome, p.cognome = :cognome, p.diminutivo = :diminutivo, p.azienda = :azienda, p.indirizzo = :indirizzo, p.citta = :citta, p.provincia = :provincia, p.nazione = :nazione, p.telefono = :telefono, p.cellulare = :cellulare, p.fax = :fax, p.pIva = :pIva, p.cf = :cf, p.mail = :mail, p.foto = :foto, p.dataAssunzione = :dataAssunzione, p.matricola = :matricola, p.idFiliale = :idFiliale, p.idMansione = :idMansione, p.idDeposito = :idDeposito, p.idRiferimento = :idRiferimento, p.visitatore = :visitatore, p.accessNumber = :accessNumber, p.accessCount = :accessCount, p.accessUpdate = :accessUpdate, p.luogoNascita = :luogoNascita, p.dataNascita = :dataNascita, p.dataScadCertificato = :dataScadCertificato, p.preposto = :preposto, p.antincendio = :antincendio, p.primoSoccorso = :primoSoccorso, p.tipoDocumento = :tipoDocumento, p.numeroDocumento = :numeroDocumento, p.dataScadenzaDoc = :dataScadenzaDoc, p.giorniScadenza = :giorniScadenza, p.duvri = :duvri, p.numCentriCosto = :numCentriCosto, p.flagDocPrivacy = :flagDocPrivacy, p.dataConsegnaDocPrivacy = :dataConsegnaDocPrivacy " +
                        "WHERE p.id = :id",
                Parameters.with("idRuna", person.getIdRuna())
                        .and("nome", person.getNome())
                        .and("cognome", person.getCognome())
                        .and("diminutivo", person.getDiminutivo())
                        .and("azienda", person.getAzienda())
                        .and("indirizzo", person.getIndirizzo())
                        .and("citta", person.getCitta())
                        .and("provincia", person.getProvincia())
                        .and("nazione", person.getNazione())
                        .and("telefono", person.getTelefono())
                        .and("cellulare", person.getCellulare())
                        .and("telefono", person.getTelefono())
                        .and("fax", person.getFax())
                        .and("pIva", person.getpIva())
                        .and("cf", person.getCf())
                        .and("mail", person.getMail())
                        .and("foto", person.getFoto())
                        .and("dataAssunzione", person.getDataAssunzione())
                        .and("matricola", person.getMatricola())
                        .and("idFiliale", person.getIdFiliale())
                        .and("idMansione", person.getIdMansione())
                        .and("idDeposito", person.getIdDeposito())
                        .and("idRiferimento", person.getIdRiferimento())
                        .and("visitatore", person.getVisitatore())
                        .and("accessNumber", person.getAccessNumber())
                        .and("accessCount", person.getAccessCount())
                        .and("accessUpdate", person.getAccessUpdate())
                        .and("luogoNascita", person.getLuogoNascita())
                        .and("dataNascita", person.getDataNascita())
                        .and("dataScadCertificato", person.getDataScadCertificato())
                        .and("preposto", person.getPreposto())
                        .and("antincendio", person.getAntincendio())
                        .and("primoSoccorso", person.getPrimoSoccorso())
                        .and("tipoDocumento", person.getTipoDocumento())
                        .and("numeroDocumento", person.getNumeroDocumento())
                        .and("dataScadenzaDoc", person.getDataScadenzaDoc())
                        .and("giorniScadenza", person.getGiorniScadenza())
                        .and("duvri", person.getDuvri())
                        .and("numCentriCosto", person.getNumCentriCosto())
                        .and("flagDocPrivacy", person.isFlagDocPrivacy())
                        .and("dataConsegnaDocPrivacy", person.getDataConsegnaDocPrivacy())
                        .and("id", idPersona )
        );
        person.setIdPersona(idPersona);
        return update > 0;
    }

    public List<EmployeeContactList> getPhoneDirectory() {
        String azienda = "Secondo Mona";
        return em.createQuery(
                        "SELECT new data.model.EmployeeContactList(p.idPersona, p.nome, p.cognome, p.mail, p.telefono, p.cellulare) " +
                                "FROM Person p WHERE p.azienda = :azienda", EmployeeContactList.class)
                .setParameter("azienda", azienda)
                .getResultList();
    }
}
