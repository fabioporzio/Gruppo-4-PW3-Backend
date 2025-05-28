package data.repository;

import data.model.Badge;
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
        return find("SELECT b\n" +
                "FROM Badge b\n" +
                "WHERE attivata = false\n" +
                "ORDER BY id ASC", false).firstResult();
    }

    @Transactional
    public boolean updateBadgeToStart(Badge badge, CreatePersonRequest createPersonRequest) {
        int update = update("UPDATE Badge b " +
                        "SET b.persona = :persona, b.dataInizio = :dataInizio, b.dataFine = :dataFine, b.attivata = :attivata, b.dataRestituzione = :dataRestituzione " +
                        "WHERE b.id = :id",
                Parameters.with("dataInizio", badge.getDataInizio())
                        .and("dataFine", badge.getDataFine())
                        .and("persona", createPersonRequest)
                        .and("attivata", badge.getAttivata())
                        .and("dataRestituzione", badge.getDataRestituzione())
                        .and("id", badge.getId())
        );
        return update > 0;
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
