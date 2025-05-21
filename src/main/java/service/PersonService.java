package service;

import data.model.EmployeeContactList;
import data.repository.PersonRepository;
import web.model.EmployeeContactListResponse;
import jakarta.enterprise.context.ApplicationScoped;

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
