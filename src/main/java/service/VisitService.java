package service;

import data.model.ItProvision;
import data.model.Person.Person;
import data.model.Visit;
import data.repository.ItProvisionRepository;
import data.repository.PersonRepository;
import data.repository.VisitRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import web.model.CreateVisitRequest;
import web.model.VisitResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VisitService {

    private final VisitRepository visitRepository;
    private final PersonRepository personRepository;
    private final ItProvisionRepository itProvisionRepository;

    public VisitService(VisitRepository visitRepository, PersonRepository personRepository, ItProvisionRepository itProvisionRepository) {
        this.visitRepository = visitRepository;
        this.personRepository = personRepository;
        this.itProvisionRepository = itProvisionRepository;
    }

    public List<VisitResponse> getVisitsByPersonAndByDate(int idResponsabile, LocalDate fromDate) {
        List<VisitResponse> visitResponses = new ArrayList<>();
        List<Visit> visits = visitRepository.getVisitsByPersonAndByDate(idResponsabile, fromDate);

        for (Visit visit : visits) {
            VisitResponse visitResponse = getVisitResponse(visit);
            visitResponses.add(visitResponse);
        }
        return visitResponses;
    }

    public List<VisitResponse> getVisitsByPersonAndBetweenDates(int idResponsabile, LocalDate fromDate, LocalDate toDate) {
        List<VisitResponse> visitResponses = new ArrayList<>();
        List<Visit> visits = visitRepository.getVisitsByPersonAndBetweenDates(idResponsabile, fromDate, toDate);

        for (Visit visit : visits) {
            VisitResponse visitResponse = getVisitResponse(visit);
            visitResponses.add(visitResponse);
        }
        return visitResponses;
    }

    @Transactional
    public Visit addVisit(CreateVisitRequest createVisitRequest) {
        Person visitatore = personRepository.findById((createVisitRequest.getIdVisitatore()));
        Person responsabile = personRepository.findById((createVisitRequest.getIdResponsabile()));
        ItProvision itProvision = itProvisionRepository.findById(createVisitRequest.getIdMaterialeInformatico());

        Visit visit = getVisit(createVisitRequest, visitatore, responsabile, itProvision);
        if (visit == null) {
            return null;
        }

        visitRepository.persist(visit);
        return visit;
    }

    @Transactional
    public boolean updateVisitToStart(Visit visit){
        return visitRepository.updateVisitToStart(visit);
    }

    @Transactional
    public Visit updateVisit(int idVisit, CreateVisitRequest createVisitRequest) {
        Person visitatore = personRepository.findById(createVisitRequest.getIdVisitatore());
        Person responsabile = personRepository.findById(createVisitRequest.getIdResponsabile());
        ItProvision itProvision = itProvisionRepository.findById(createVisitRequest.getIdMaterialeInformatico());
        Visit visit = getVisit(createVisitRequest, visitatore, responsabile, itProvision);
        if (visit == null) {
            return null;
        }

        boolean updated = visitRepository.updateVisit(visit, idVisit);
        if (updated) {
            return visit;
        }
        else {
            return null;
        }
    }

    public Visit getVisitById(int idVisit) {
        return visitRepository.findById(idVisit);
    }

    @Transactional
    public boolean deleteVisit(int idVisit) {
        return visitRepository.deleteById(idVisit);
    }

    public List<Visit> getAllVisits() {
        return visitRepository.findAll().list();
    }

    public List<Visit> getVisitsByPerson(int id) {
        return visitRepository.findByPerson(id);
    }

    public List<Visit> getFutureVisits() {
        return visitRepository.getFutureVisit();
    }

    public List<Visit> getTodayVisits() {
        return visitRepository.getTodayVisit();
    }

    public Visit getVisit(CreateVisitRequest createVisitRequest, Person visitatore, Person responsabileVisita, ItProvision itProvision) {
        return new Visit(
                createVisitRequest.getDataInizio(),
                createVisitRequest.getDataFine(),
                createVisitRequest.getOraInizio(),
                createVisitRequest.getOraFine(),
                createVisitRequest.getMotivo(),
                visitatore,
                responsabileVisita,
                createVisitRequest.isFlagDPI(),
                itProvision,
                createVisitRequest.getVincolo(),
                createVisitRequest.isFlagAccessoConAutomezzo()
        );
    }

    public VisitResponse getVisitResponse(Visit visit) {
        return new VisitResponse(
                visit.getId(),
                visit.getDataInizio(),
                visit.getDataFine(),
                visit.getOraInizio(),
                visit.getOraFine(),
                visit.getMotivo(),
                visit.getPersonaVisitatore(),
                visit.getResponsabile(),
                visit.isFlagDPI(),
                visit.getMaterialeInformatico(),
                visit.isFlagAccessoConAutomezzo()
        );
    }
}
