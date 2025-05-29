package service;

import data.model.Badge;
import data.model.Person.Person;
import data.model.Visit;
import data.repository.BadgeRepository;
import data.repository.VisitRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import web.model.CreateBadgeRequest;
import web.model.createPerson.CreatePersonRequest;

import java.time.LocalDate;
import java.time.LocalTime;

@ApplicationScoped
public class BadgeService {
    private final BadgeRepository badgeRepository;
    private final BadgeRecordService badgeRecordService;
    private final PersonService personService;
    private final VisitService visitService;
    private final BadgeAssignmentService badgeAssignmentService;

    public BadgeService(BadgeRepository badgeRepository, BadgeRecordService badgeRecordService, PersonService personService, VisitService visitService, BadgeAssignmentService badgeAssignmentService) {
        this.badgeRepository = badgeRepository;
        this.badgeRecordService = badgeRecordService;
        this.personService = personService;
        this.visitService = visitService;
        this.badgeAssignmentService = badgeAssignmentService;
    }

    @Transactional
    public Visit assignBadge(int idVisita){
        Badge badge = badgeRepository.findBadgeNotAssigned();
        badge.setAttivata(true);
        badge.setDataInizio(LocalDate.now());
        badge.setDataFine(LocalDate.now());
        badge.setDataRestituzione(LocalDate.now());
        Person person = personService.getPersonByVisit(idVisita);
        badge.setPersona(person);
        badgeAssignmentService.createBadgeAssignment(badge);
        Visit visit = visitService.getVisitById(idVisita);
        visit.setDataInizio(LocalDate.now());
        visit.setOraInizio(LocalTime.now());
        badgeRecordService.entryStamp(badge);
        return visit;
    }

    @Transactional
    public Visit removeBadge(int idVisita){
        Badge badge = badgeRepository.finBadgeAssignedToTheVisit(idVisita);
        badge.setPersona(null);
        badge.setAttivata(false);
        badge.setDataInizio(null);
        badge.setDataFine(null);
        badge.setDataRestituzione(null);
        Visit visit = visitService.getVisitById(idVisita);
        visit.setDataFine(LocalDate.now());
        visit.setOraFine(LocalTime.now());
        badgeRecordService.outStamp(badge);
        return visit;
    }

}
