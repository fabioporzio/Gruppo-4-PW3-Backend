package web;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.PersonService;
import web.model.EmployeeContactListResponse;

import java.util.List;

@Path("/employee-contact-list")
@DenyAll
public class EmployeeContactListResource {

    private final PersonService personService;

    public EmployeeContactListResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @RolesAllowed({"Admin", "Reception", "Requester"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeContactListResponse> getPhoneDirectory() {
        return personService.getPhoneDirectory();
    }
}
