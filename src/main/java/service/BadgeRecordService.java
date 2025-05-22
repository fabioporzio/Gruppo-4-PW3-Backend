package service;

import data.model.BadgeRecordHistory;
import data.repository.BadgeRecordRepository;
import jakarta.enterprise.context.ApplicationScoped;
import web.model.BadgeRecordHistoryResponse;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BadgeRecordService {

    private final BadgeRecordRepository badgeRecordRepository;

    public BadgeRecordService(BadgeRecordRepository badgeRecordRepository) {
        this.badgeRecordRepository = badgeRecordRepository;
    }

    public List<BadgeRecordHistoryResponse> getBadgeRecordHistoryForSmEmployees() {
        List<BadgeRecordHistoryResponse> badgeRecordHistoryResponses = new ArrayList<>();
        List<BadgeRecordHistory> badgeRecordHistory = badgeRecordRepository.getBadgeRecordHistoryForSmEmployees();

        for (BadgeRecordHistory badgeRecordHistoryElement : badgeRecordHistory) {
            BadgeRecordHistoryResponse badgeRecordHistoryResponse = getBadgeRecordHistoryResponse(badgeRecordHistoryElement);
            badgeRecordHistoryResponses.add(badgeRecordHistoryResponse);
        }
        return badgeRecordHistoryResponses;
    }

    public List<BadgeRecordHistoryResponse> getBadgeRecordHistoryVisitors() {
        List<BadgeRecordHistoryResponse> badgeRecordHistoryResponses = new ArrayList<>();
        List<BadgeRecordHistory> badgeRecordHistory = badgeRecordRepository.getBadgeRecordHistoryVisitors();

        for (BadgeRecordHistory badgeRecordHistoryElement : badgeRecordHistory) {
            BadgeRecordHistoryResponse badgeRecordHistoryResponse = getBadgeRecordHistoryResponse(badgeRecordHistoryElement);
            badgeRecordHistoryResponses.add(badgeRecordHistoryResponse);
        }
        return badgeRecordHistoryResponses;
    }

    public List<BadgeRecordHistoryResponse> getBadgeRecordHistoryOfLunchArea() {
        List<BadgeRecordHistoryResponse> badgeRecordHistoryResponses = new ArrayList<>();
        List<BadgeRecordHistory> badgeRecordHistory = badgeRecordRepository.getBadgeRecordHistoryOfLunchArea();

        for (BadgeRecordHistory badgeRecordHistoryElement : badgeRecordHistory) {
            BadgeRecordHistoryResponse badgeRecordHistoryResponse = getBadgeRecordHistoryResponse(badgeRecordHistoryElement);
            badgeRecordHistoryResponses.add(badgeRecordHistoryResponse);
        }
        return badgeRecordHistoryResponses;
    }

    public BadgeRecordHistoryResponse getBadgeRecordHistoryResponse(BadgeRecordHistory badgeRecordHistory) {
        return new BadgeRecordHistoryResponse(
                badgeRecordHistory.getIdPersona(),
                badgeRecordHistory.getNome(),
                badgeRecordHistory.getCognome(),
                badgeRecordHistory.getAzienda(),
                badgeRecordHistory.getEmail(),
                badgeRecordHistory.getIdBadge(),
                badgeRecordHistory.getCodiceBadge(),
                badgeRecordHistory.getIdTimbratura(),
                badgeRecordHistory.getDataTimbratura(),
                badgeRecordHistory.getOraTimbratura(),
                badgeRecordHistory.getIdTimbratrice(),
                badgeRecordHistory.getDescrizioneTimbratrice()
        );
    }
}
