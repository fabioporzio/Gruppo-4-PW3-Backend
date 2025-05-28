package service;

import data.model.Badge;
import data.model.BadgeAssignment;
import data.repository.BadgeAssignmentRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;

@ApplicationScoped
public class BadgeAssignmentService {
    private final BadgeAssignmentRepository badgeAssignmentRepository;

    public BadgeAssignmentService(BadgeAssignmentRepository badgeAssignmentRepository) {
        this.badgeAssignmentRepository = badgeAssignmentRepository;
    }

    public void createBadgeAssignment(Badge badge) {
        BadgeAssignment badgeAssignment = new BadgeAssignment();
        badgeAssignment.setBadge(badge);
        badgeAssignment.setPersona(badge.getPersona());
        badgeAssignment.setDataInizioEffettiva(LocalDate.now());
        badgeAssignment.setDataFineEffettiva(LocalDate.now());
        badgeAssignmentRepository.persist(badgeAssignment);
    }
}
