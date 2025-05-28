package data.repository;

import data.model.BadgeReader;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BadgeReaderRepository implements PanacheRepositoryBase<BadgeReader, Integer> {
}
