package web;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.PersonService;
import web.model.createPerson.CreatePersonRequest;
import web.model.createPerson.CreatePersonResponse;

@Path("/people")
@DenyAll
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CreatePersonResponse createPerson(CreatePersonRequest createPersonRequest) {
        return personService.persistPerson(createPersonRequest);
    }
}
