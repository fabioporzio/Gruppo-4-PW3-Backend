package data.repository;

import data.model.BadgeRecordHistory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.core.Context;

import java.util.List;

@ApplicationScoped
public class BadgeRecordRepository {

    @Context
    EntityManager em;

    public List<BadgeRecordHistory> getBadgeRecordHistoryForSmEmployees() {
        String azienda = "Secondo Mona";

        return em.createQuery(
                ("SELECT new data.model.BadgeRecordHistory(" +
                        "p.idPersona, p.nome, p.cognome, p.azienda, p.mail, " +
                        "b.id, b.codiceBadge, " +
                        "bRercord.badge.id, bRercord.id.data, bRercord.id.ora, " +
                        "bReader.id, bReader.descrizione" +
                        ") " +
                        "FROM BadgeRecord bRercord " +
                        "INNER JOIN BadgeReader bReader ON bReader.id = bRercord.timbratrice.id " +
                        "LEFT JOIN Badge b ON b.id = bRercord.badge.id " +
                        "LEFT JOIN BadgeAssignment ba ON ba.badge.id = b.id " +
                        "LEFT JOIN Person p ON p.idPersona = ba.persona.id " +
                        "WHERE p.azienda = :azienda"), BadgeRecordHistory.class)
                .setParameter("azienda", azienda)
                .getResultList();
    }

    public List<BadgeRecordHistory> getBadgeRecordHistoryVisitors() {
        String tipoBadge = "Dipendente";

        return em.createQuery(
                        ("SELECT new data.model.BadgeRecordHistory(" +
                                "p.idPersona, p.nome, p.cognome, p.azienda, p.mail, " +
                                "b.id, b.codiceBadge, " +
                                "bRercord.badge.id, bRercord.id.data, bRercord.id.ora, " +
                                "bReader.id, bReader.descrizione" +
                                ") " +
                                "FROM BadgeRecord bRercord " +
                                "INNER JOIN BadgeReader bReader ON bReader.id = bRercord.timbratrice.id " +
                                "LEFT JOIN Badge b ON b.id = bRercord.badge.id " +
                                "LEFT JOIN BadgeAssignment ba ON ba.badge.id = b.id " +
                                "LEFT JOIN Person p ON p.idPersona = ba.persona.id " +
                                "WHERE b.tipoBadge != :tipoBadge"), BadgeRecordHistory.class)
                .setParameter("tipoBadge", tipoBadge)
                .getResultList();
    }
}
