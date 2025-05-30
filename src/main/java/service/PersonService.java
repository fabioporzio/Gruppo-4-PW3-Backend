package service;

import data.model.Badge;
import data.model.EmployeeContactList;
import data.model.Person.Person;
import data.model.Ruolo;
import data.repository.PersonRepository;
import data.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import web.model.EmployeeContactListResponse;
import jakarta.enterprise.context.ApplicationScoped;
import web.model.createPerson.CreatePersonRequest;
import web.model.createPerson.CreatePersonResponse;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    public PersonService(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    public List<CreatePersonResponse> getAllPeople() {
        List<Person> people = personRepository.findAll().list();
        List<CreatePersonResponse> createPersonResponses = new ArrayList<>();
        for (Person person : people) {
            createPersonResponses.add(getCreatePersonResponse(person));
        }
        return createPersonResponses;
    }

    public CreatePersonResponse getPersonById(int idPersona) {
        Person person = personRepository.findById(idPersona);
        if (person == null) {
            return null;
        }
        return getCreatePersonResponse(person);
    }

    public boolean deletePersonById(int idPersona) {
        return personRepository.deleteById(idPersona);
    }

    public CreatePersonResponse getPersonByUser(int idUser) {
        Person person = personRepository.findByUserId(idUser);
        if (person == null) {
            return null;
        }
        return getCreatePersonResponse(person);
    }

    public Person getPersonByVisit(int idVisit) {
        return personRepository.findByVisit(idVisit);
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
        Ruolo ruolo = roleRepository.findById(createPersonRequest.getIdRuolo());
        Person person = getPerson(createPersonRequest, ruolo);

        personRepository.persist(person);

        return getCreatePersonResponse(person);
    }

    @Transactional
    public Person getPersonByBadge(Badge badge) {
        System.out.println(badge.getId());
        return personRepository.findByBadge(badge.getId());
    }

    @Transactional
    public Response updatePerson(int idPersona, CreatePersonRequest createPersonRequest) {
        Ruolo ruolo = roleRepository.findById(createPersonRequest.getIdRuolo());
        Person person = getPerson(createPersonRequest, ruolo);
        boolean updated = personRepository.updatePersonData(person, idPersona);

        if (updated) {
            return Response.ok(getCreatePersonResponse(person)).build();
        }

        throw new EntityNotFoundException();
    }

    public CreatePersonRequest fromPerson(Person person) {
        return new CreatePersonRequest(
                person.getIdRuna(),
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
                person.getDataAssunzione(),
                person.getMatricola(),
                person.getIdFiliale(),
                person.getIdMansione(),
                person.getIdDeposito(),
                person.getIdRiferimento(),
                person.getVisitatore(),
                person.getAccessNumber(),
                person.getAccessCount(),
                person.getAccessUpdate(),
                person.getLuogoNascita(),
                person.getDataNascita(),
                person.getDataScadCertificato(),
                person.getPreposto(),
                person.getAntincendio(),
                person.getPrimoSoccorso(),
                person.getTipoDocumento(),
                person.getNumeroDocumento(),
                person.getDataScadenzaDoc(),
                person.getGiorniScadenza(),
                person.getDuvri(),
                person.getNumCentriCosto(),
                person.isFlagDocPrivacy(),
                person.getDataConsegnaDocPrivacy(),
                person.getRuolo().getId()
        );
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
                person.getDataConsegnaDocPrivacy(),
                person.getRuolo()
        );
    }

    private Person getPerson(CreatePersonRequest createPersonRequest, Ruolo ruolo) {
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
                createPersonRequest.getTipoDocumento(),
                createPersonRequest.getNumeroDocumento(),
                createPersonRequest.getDataScadenzaDoc(),
                createPersonRequest.getGiorniScadenza(),
                createPersonRequest.getDuvri(),
                createPersonRequest.getNumCentriCosto(),
                createPersonRequest.getFlagDocPrivacy(),
                createPersonRequest.getDataConsegnaDocPrivacy(),
                ruolo
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
