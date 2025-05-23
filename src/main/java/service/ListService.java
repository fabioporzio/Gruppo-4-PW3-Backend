package service;

import data.model.Person.Person;
import data.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ListService {

    private PersonRepository personRepository;

    @Inject
    public ListService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Metodo helper per fare la differenza tra due liste
    private Set<Person> difference(List<Person> included, List<Person> excluded) {
        Set<Person> includedSet = new HashSet<>(included);
        includedSet.removeAll(new HashSet<>(excluded));
        return includedSet;
    }

    // Metodo helper per contare la differenza tra due liste
    private int countDifference(List<Person> included, List<Person> excluded) {
        return difference(included, excluded).size();
    }

    // Metodo helper per unire più liste in un Set
    @SafeVarargs
    private final Set<Person> union(List<Person>... lists) {
        Set<Person> result = new HashSet<>();
        for (List<Person> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    public int getCountPeopleInCompany() {
        return countDifference(personRepository.findPeopleSMInCompany(), personRepository.findPeopleSMOutCompany());
    }

    public List<Person> getPeopleInCompany() {
        return new ArrayList<>(difference(personRepository.findPeopleSMInCompany(), personRepository.findPeopleSMOutCompany()));
    }

    public int getCountPeopleLunchArea() {
        List<Person> lunchArea = personRepository.findPeopleLunchArea();
        Set<Person> outSet = union(
                personRepository.findPeopleSMOutCompany(),
                personRepository.findVisitorOutCompany(),
                personRepository.findMainetanceInCompany()
        );
        return difference(lunchArea, new ArrayList<>(outSet)).size();
    }

    public int getCountPeopleCigarette() {
        List<Person> cigaretteArea = personRepository.findPeopleCigarette();
        Set<Person> outSet = union(
                personRepository.findPeopleSMOutCompany(),
                personRepository.findVisitorOutCompany(),
                personRepository.findMainetanceInCompany()
        );
        return difference(cigaretteArea, new ArrayList<>(outSet)).size();
    }

    public int getCountPeopleParking() {
        List<Person> parkingArea = personRepository.findPeopleParking();
        Set<Person> outSet = union(
                personRepository.findPeopleSMOutCompany(),
                personRepository.findVisitorOutCompany(),
                personRepository.findMainetanceInCompany()
        );
        return difference(parkingArea, new ArrayList<>(outSet)).size();
    }

    public int getCountVisitorInCompany() {
        return countDifference(personRepository.findVisitorInCompany(), personRepository.findVisitorOutCompany());
    }

    public List<Person> getVisitorInCompany() {
        return new ArrayList<>(difference(personRepository.findVisitorInCompany(), personRepository.findVisitorOutCompany()));
    }

    public int getCountMaintenanceInCompany() {
        return countDifference(personRepository.findMainetanceInCompany(), personRepository.findMainetanceOutCompany());
    }

    public List<Person> getMaintenanceInCompany() {
        return new ArrayList<>(difference(personRepository.findMainetanceInCompany(), personRepository.findMainetanceOutCompany()));
    }

}