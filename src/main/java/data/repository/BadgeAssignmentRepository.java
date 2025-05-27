package data.repository;

import data.model.BadgeAssignment;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BadgeAssignmentRepository implements PanacheRepositoryBase<BadgeAssignment, Integer> {
}
