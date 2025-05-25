package data.repository;

import data.model.ItProvision;
import data.model.Person.Person;
import data.model.Visit;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import web.model.CreateVisitRequest;

import java.util.List;

@ApplicationScoped
public class VisitRepository implements PanacheRepositoryBase<Visit, Integer> {

    public List<Visit> getFutureVisit() {
        return getEntityManager().createNativeQuery("SELECT *\n" +
                "FROM Visite\n" +
                "WHERE DataInizio >= DATEADD(DAY, 1, CAST(GETDATE() AS DATE));", Visit.class)
                .getResultList();
    }

    public List<Visit> getTodayVisit() {
        return getEntityManager().createNativeQuery("SELECT *\n" +
                        "FROM Visite\n" +
                        "WHERE DataInizio = CAST(GETDATE() AS DATE);", Visit.class)
                .getResultList();
    }

    @Transactional
    public boolean updateVisit(Visit visit, int idVisita) {
        int update = update("UPDATE Visit v " +
                        "SET v.dataInizio = :dataInizio, v.dataFine = :dataFine, v.oraInizio = :oraInizio, v.oraFine = :oraFine, v.motivo = :motivo, v.personaVisitatore = :personaVisitatore, v.responsabile = :responsabile, v.flagDPI = :flagDPI, v.materialeInformatico = :materialeInformatico, v.vincolo = :vincolo, v.flagAccessoConAutomezzo = :flagAccessoConAutomezzo " +
                        "WHERE v.id = :id",
                Parameters.with("dataInizio", visit.getDataInizio())
                        .and("dataFine", visit.getDataFine())
                        .and("oraInizio", visit.getOraInizio())
                        .and("oraFine", visit.getOraFine())
                        .and("motivo", visit.getMotivo())
                        .and("personaVisitatore", visit.getPersonaVisitatore())
                        .and("responsabile", visit.getResponsabile())
                        .and("flagDPI", visit.isFlagDPI())
                        .and("materialeInformatico", visit.getMaterialeInformatico())
                        .and("vincolo", visit.getVincolo())
                        .and("flagAccessoConAutomezzo", visit.isFlagAccessoConAutomezzo())
                        .and("id", idVisita )
        );
        visit.setId(idVisita);
        return update > 0;
    }
}
