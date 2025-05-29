package data.repository;

import data.model.Badge;
import data.model.Person.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import web.model.CreateBadgeRequest;
import web.model.createPerson.CreatePersonRequest;

import java.time.LocalDate;

@ApplicationScoped
public class BadgeRepository implements PanacheRepositoryBase<Badge, Integer> {


    public Badge findBadgeNotAssigned() {
        return getEntityManager()
                .createQuery("SELECT b " +
                        "FROM Badge b " +
                        "WHERE b.attivata = :value "+
                        "ORDER BY b.id ASC", Badge.class)
                .setParameter("value", false)
                .getSingleResult();
    }

    @Transactional
    public boolean updateBadgeToStart(Badge badge) {
        int update = update("UPDATE Badge b " +
                        "SET b.persona = :persona, b.dataInizio = :dataInizio, b.dataFine = :dataFine, b.attivata = :attivata, b.dataRestituzione = :dataRestituzione " +
                        "WHERE b.id = :id",
                Parameters.with("dataInizio", badge.getDataInizio())
                        .and("dataFine", badge.getDataFine())
                        .and("persona", badge.getPersona())
                        .and("attivata", badge.getAttivata())
                        .and("dataRestituzione", badge.getDataRestituzione())
                        .and("id", badge.getId())
        );
        return update > 0;
    }

    public Badge finBadgeAssignedToTheVisit(int idVisita) {
        return getEntityManager()
                .createQuery("SELECT b\n" +
                        "FROM Badge b\n" +
                        "INNER JOIN Person p ON b.persona.id = p.id\n" +
                        "INNER JOIN Visit v ON v.personaVisitatore.id = p.id\n" +
                        "WHERE v.id = :idVisit", Badge.class)
                .setParameter("idVisit", idVisita)
                .getSingleResult();
    }

    @Transactional
    public boolean updateBadgeToEnd(CreateBadgeRequest badge) {
        int update = update("UPDATE Badge b " +
                        "SET b.persona = :persona, b.dataInizio = :dataInizio, b.dataFine = :dataFine, b.attivata = :attivata, b.dataRestituzione = :dataRestituzione " +
                        "WHERE b.id = :id",
                Parameters.with("dataInizio", null)
                        .and("dataFine", null)
                        .and("persona", null)
                        .and("attivata", false)
                        .and("dataRestituzione", null)
                        .and("id", badge.getId())
        );
        return update > 0;
    }

}
