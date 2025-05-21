package data.repository;

import data.model.Person.Person;
import data.model.EmployeeContactList;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.core.Context;

import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person, Integer> {

    @Context
    EntityManager em;

    public List<EmployeeContactList> getPhoneDirectory() {
        String azienda = "Secondo Mona";
        return em.createQuery(
                        "SELECT new data.model.EmployeeContactList(p.idPersona, p.nome, p.cognome, p.mail, p.telefono, p.cellulare) " +
                                "FROM Person p WHERE p.azienda = :azienda", EmployeeContactList.class)
                .setParameter("azienda", azienda)
                .getResultList();
    }
}
