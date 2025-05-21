package web;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.PersonService;
import web.model.EmployeeContactListResponse;

import java.util.List;

@Path("/employee-contact-list")
@DenyAll
public class EmployeeContactListApi {

    private final PersonService personService;

    public EmployeeContactListApi(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeContactListResponse> getPhoneDirectory() {
        return personService.getPhoneDirectory();
    }
}
