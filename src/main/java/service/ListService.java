package service;

import data.model.Person.Person;
import data.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ListService {
    private PersonRepository personRepository;

    public ListService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public int getCountPeopleInCompany() {
        List<Person> peopleIn = personRepository.findPeopleSMInCompany();
        List<Person> peopleOut = personRepository.findPeopleSMOutCompany();
        Set<Person> inSet = new HashSet<>(peopleIn);
        Set<Person> outSet = new HashSet<>(peopleOut);

        inSet.removeAll(outSet);

        return inSet.size();
    }

    public int getCountPeopleLaunchArea(){
        List<Person> peopleLuncheArea = personRepository.findPeopleLunchArea();

        List<Person> peopleOut = personRepository.findPeopleSMOutCompany();
        List<Person> visitorOut = personRepository.findVisitorOutCompany();
        List<Person> maintenanceOut = personRepository.findMainetanceOutCompany();

        Set<Person> outSet = new HashSet<>();
        outSet.addAll(peopleOut);
        outSet.addAll(visitorOut);
        outSet.addAll(maintenanceOut);

        Set<Person> pauseSet = new HashSet<>();
        pauseSet.addAll(peopleLuncheArea);

        pauseSet.removeAll(outSet);

        return pauseSet.size();
    }

    public int getCountPeopleCigarette(){
        List<Person> peopleLuncheArea = personRepository.findPeopleCigarette();

        List<Person> peopleOut = personRepository.findPeopleSMOutCompany();
        List<Person> visitorOut = personRepository.findVisitorOutCompany();
        List<Person> maintenanceOut = personRepository.findMainetanceOutCompany();

        Set<Person> outSet = new HashSet<>();
        outSet.addAll(peopleOut);
        outSet.addAll(visitorOut);
        outSet.addAll(maintenanceOut);

        Set<Person> pauseSet = new HashSet<>();
        pauseSet.addAll(peopleLuncheArea);

        pauseSet.removeAll(outSet);

        return pauseSet.size();
    }

    public int getCountPeopleParking(){
        List<Person> peopleLuncheArea = personRepository.findPeopleParking();

        List<Person> peopleOut = personRepository.findPeopleSMOutCompany();
        List<Person> visitorOut = personRepository.findVisitorOutCompany();
        List<Person> maintenanceOut = personRepository.findMainetanceOutCompany();

        Set<Person> outSet = new HashSet<>();
        outSet.addAll(peopleOut);
        outSet.addAll(visitorOut);
        outSet.addAll(maintenanceOut);

        Set<Person> pauseSet = new HashSet<>();
        pauseSet.addAll(peopleLuncheArea);

        pauseSet.removeAll(outSet);

        return pauseSet.size();
    }

    public List<Person> getPeopleInCompany() {
        List<Person> peopleIn = personRepository.findPeopleSMInCompany();
        List<Person> peopleOut = personRepository.findPeopleSMOutCompany();

        Set<Person> inSet = new HashSet<>(peopleIn);
        Set<Person> outSet = new HashSet<>(peopleOut);

        inSet.removeAll(outSet);

        return new ArrayList<>(inSet);
    }

    public int getCountVisitorInCompany() {
        List<Person> peopleIn = personRepository.findVisitorInCompany();
        List<Person> peopleOut = personRepository.findVisitorOutCompany();
        Set<Person> inSet = new HashSet<>(peopleIn);
        Set<Person> outSet = new HashSet<>(peopleOut);

        inSet.removeAll(outSet);

        return inSet.size();
    }

    public List<Person> getVisitorInCompany() {
        List<Person> peopleIn = personRepository.findVisitorInCompany();
        List<Person> peopleOut = personRepository.findVisitorOutCompany();

        Set<Person> inSet = new HashSet<>(peopleIn);
        Set<Person> outSet = new HashSet<>(peopleOut);

        inSet.removeAll(outSet);

        return new ArrayList<>(inSet);
    }

    public int getCountMainetanceInCompany() {
        List<Person> peopleIn = personRepository.findMainetanceInCompany();
        List<Person> peopleOut = personRepository.findMainetanceOutCompany();
        Set<Person> inSet = new HashSet<>(peopleIn);
        Set<Person> outSet = new HashSet<>(peopleOut);

        inSet.removeAll(outSet);

        return inSet.size();
    }

    public List<Person> getMainetanceInCompany() {
        List<Person> peopleIn = personRepository.findMainetanceInCompany();
        List<Person> peopleOut = personRepository.findMainetanceOutCompany();

        Set<Person> inSet = new HashSet<>(peopleIn);
        Set<Person> outSet = new HashSet<>(peopleOut);

        inSet.removeAll(outSet);

        return new ArrayList<>(inSet);
    }



}
