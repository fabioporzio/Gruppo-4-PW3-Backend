package service;

import data.model.EmployeeContactList;
import data.model.Person.Person;
import data.repository.PersonRepository;
import jakarta.transaction.Transactional;
import web.model.EmployeeContactListResponse;
import jakarta.enterprise.context.ApplicationScoped;
import web.model.createPerson.CreatePersonRequest;
import web.model.createPerson.CreatePersonResponse;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<EmployeeContactListResponse> getPhoneDirectory() {
        List<EmployeeContactListResponse> employeeContactListResponses = new ArrayList<>();
        List<EmployeeContactList> employeeContactList = personRepository.getPhoneDirectory();

        for (EmployeeContactList employeeContactListElement : employeeContactList) {
            EmployeeContactListResponse employeeContactListResponse = createPhoneDirectoryResponse(employeeContactListElement);
            employeeContactListResponses.add(employeeContactListResponse);
        }
        return employeeContactListResponses;
    }

    @Transactional
    public CreatePersonResponse persistPerson(CreatePersonRequest createPersonRequest) {
        Person person = getPerson(createPersonRequest);

        personRepository.persist(person);

        return getCreatePersonResponse(person);
    }

    private CreatePersonResponse getCreatePersonResponse(Person person) {
        return new CreatePersonResponse(
                person.getIdPersona(),
                person.getNome(),
                person.getCognome(),
                person.getDiminutivo(),
                person.getAzienda(),
                person.getIndirizzo(),
                person.getCitta(),
                person.getProvincia(),
                person.getNazione(),
                person.getTelefono(),
                person.getCellulare(),
                person.getFax(),
                person.getpIva(),
                person.getCf(),
                person.getMail(),
                person.getFoto(),
                person.getLuogoNascita(),
                person.getDataNascita(),
                person.getTipoDocumento(),
                person.getNumeroDocumento(),
                person.getDataScadenzaDoc(),
                person.getGiorniScadenza(),
                person.isFlagDocPrivacy(),
                person.getDataConsegnaDocPrivacy()
        );
    }

    private Person getPerson(CreatePersonRequest createPersonRequest) {
        return new Person(
                createPersonRequest.getIdRuna(),
                createPersonRequest.getNome(),
                createPersonRequest.getCognome(),
                createPersonRequest.getDiminutivo(),
                createPersonRequest.getAzienda(),
                createPersonRequest.getIndirizzo(),
                createPersonRequest.getCitta(),
                createPersonRequest.getProvincia(),
                createPersonRequest.getNazione(),
                createPersonRequest.getTelefono(),
                createPersonRequest.getCellulare(),
                createPersonRequest.getFax(),
                createPersonRequest.getpIva(),
                createPersonRequest.getCf(),
                createPersonRequest.getMail(),
                createPersonRequest.getFoto(),
                createPersonRequest.getDataAssunzione(),
                createPersonRequest.getMatricola(),
                createPersonRequest.getIdFiliale(),
                createPersonRequest.getIdMansione(),
                createPersonRequest.getIdDeposito(),
                createPersonRequest.getIdRiferimento(),
                createPersonRequest.getVisitatore(),
                createPersonRequest.getAccessNumber(),
                createPersonRequest.getAccessCount(),
                createPersonRequest.getAccessUpdate(),
                createPersonRequest.getLuogoNascita(),
                createPersonRequest.getDataNascita(),
                createPersonRequest.getDataScadCertificato(),
                createPersonRequest.getPreposto(),
                createPersonRequest.getAntincendio(),
                createPersonRequest.getPrimoSoccorso(),
                createPersonRequest.getTipoDocumento().name(),
                createPersonRequest.getNumeroDocumento(),
                createPersonRequest.getDataScadenzaDoc(),
                createPersonRequest.getGiorniScadenza(),
                createPersonRequest.getDuvri(),
                createPersonRequest.getNumCentriCosto(),
                createPersonRequest.getFlagDocPrivacy(),
                createPersonRequest.getDataConsegnaDocPrivacy()
        );
    }

    public EmployeeContactListResponse createPhoneDirectoryResponse(EmployeeContactList employeeContactListElement) {
        return new EmployeeContactListResponse(
                employeeContactListElement.getIdPersona(),
                employeeContactListElement.getNome(),
                employeeContactListElement.getCognome(),
                employeeContactListElement.getEmail(),
                employeeContactListElement.getTelefono(),
                employeeContactListElement.getCellulare());
    }
}
