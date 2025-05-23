package data.repository;

import data.model.ItProvision;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItProvisionRepository implements PanacheRepositoryBase<ItProvision, Integer> {

}
