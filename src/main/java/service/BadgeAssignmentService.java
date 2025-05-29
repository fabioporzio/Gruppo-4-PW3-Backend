package service;

import data.model.Badge;
import data.model.BadgeAssignment;
import data.model.Person.Person;
import data.repository.BadgeAssignmentRepository;
import data.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@ApplicationScoped
public class BadgeAssignmentService {
    private final BadgeAssignmentRepository badgeAssignmentRepository;
    private final PersonService personService;
    private final PersonRepository personRepository;

    public BadgeAssignmentService(BadgeAssignmentRepository badgeAssignmentRepository, PersonService personService, PersonRepository personRepository) {
        this.badgeAssignmentRepository = badgeAssignmentRepository;
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @Transactional
    public void createBadgeAssignment(Badge badge) {
        Person person = personService.getPersonByBadge(badge);
        BadgeAssignment badgeAssignment = new BadgeAssignment();
        badgeAssignment.setPersona(person);
        badgeAssignment.setBadge(badge);
        badgeAssignment.setPersona(badge.getPersona());
        badgeAssignment.setDataInizioEffettiva(LocalDate.now());
        badgeAssignment.setDataFineEffettiva(LocalDate.now());
        badgeAssignmentRepository.persist(badgeAssignment);
    }
}
