package service;

import data.model.Badge;
import data.model.BadgeAssignment;
import data.model.BadgeReader;
import data.model.BadgeRecordHistory;
import data.model.Person.Person;
import data.model.badgeRecord.BadgeRecord;
import data.repository.BadgeAssignmentRepository;
import data.repository.BadgeReaderRepository;
import data.repository.BadgeRecordRepository;
import data.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import web.model.BadgeRecordHistoryResponse;
import web.model.CreateBadgeRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BadgeRecordService {

    private final BadgeRecordRepository badgeRecordRepository;
    private final PersonRepository personRepository;
    private final BadgeReaderRepository badgeReaderRepository;

    public BadgeRecordService(BadgeRecordRepository badgeRecordRepository, PersonRepository personRepository, BadgeReaderRepository badgeAssignmentRepository) {
        this.badgeRecordRepository = badgeRecordRepository;
        this.personRepository = personRepository;
        this.badgeReaderRepository = badgeAssignmentRepository;
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

    public void entryStamp(Badge request) {
        Person persona = personRepository.findById(request.getPersona().getIdPersona());

        BadgeRecord badgeRecord = new BadgeRecord();
        badgeRecord.setBadge(request);
        badgeRecord.setData(LocalDate.now());
        badgeRecord.setOra(LocalTime.now());
        BadgeReader badgeReader =  badgeReaderRepository.findById(1);
        badgeRecord.setTimbratrice(badgeReader);
        badgeRecordRepository.persist(badgeRecord);
    }

    public static Badge fromRequestToEntity(CreateBadgeRequest request, Person persona) {
        return new Badge(
                persona,
                request.getIdCategoria(),
                request.getCodiceBadge(),
                request.getCodiceEsterno(),
                request.isAbilitata(),
                request.getDataInizio(),
                request.getDataFine(),
                request.isConScadenza(),
                request.getAttivata(),
                request.isEliminata(),
                request.getRegPresenza(),
                request.getDataRestituzione(),
                request.getIdRestituzione(),
                request.getApb(),
                request.getPin(),
                request.getApbState(),
                request.getTipoBadge(),
                request.getAssegnazioni()
        );
    }

}
