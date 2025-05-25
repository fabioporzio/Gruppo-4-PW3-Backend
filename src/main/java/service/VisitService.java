package service;

import data.model.ItProvision;
import data.model.Person.Person;
import data.model.Visit;
import data.repository.ItProvisionRepository;
import data.repository.PersonRepository;
import data.repository.UserRepository;
import data.repository.VisitRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import web.VisitResource;
import web.model.CreateVisitRequest;

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

    @Transactional
    public Visit addVisit(CreateVisitRequest createVisitRequest) {
        Person visitatore = personRepository.findById(createVisitRequest.getIdPersonaVisitatore());
        System.out.println(visitatore);
        Person responsabileVisita = personRepository.findById(createVisitRequest.getIdResponsabile());
        System.out.println(responsabileVisita);
        ItProvision itProvision = itProvisionRepository.findById(createVisitRequest.getIdMaterialeInformatico());

        Visit visit = getVisit(createVisitRequest, visitatore, responsabileVisita, itProvision);
        if (visit == null) {
            return null;
        }

        visitRepository.persist(visit);
        return visit;
    }

    @Transactional
    public Visit updateVisit(int idVisit, CreateVisitRequest createVisitRequest) {
        Person visitatore = personRepository.findById(createVisitRequest.getIdPersonaVisitatore());
        Person responsabileVisita = personRepository.findById(createVisitRequest.getIdResponsabile());
        ItProvision itProvision = itProvisionRepository.findById(createVisitRequest.getIdMaterialeInformatico());
        Visit visit = getVisit(createVisitRequest, visitatore, responsabileVisita, itProvision);
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
}
