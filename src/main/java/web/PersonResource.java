package web;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
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

    @GET
    @Path("/{idPersona}")
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    public CreatePersonResponse getPerson(@PathParam("idPersona") int idPersona) {
        return personService.getPersonById(idPersona);
    }

    @POST
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CreatePersonResponse createPerson(CreatePersonRequest createPersonRequest) {
        return personService.persistPerson(createPersonRequest);
    }

    @PUT
    @Path("/{idPersona}")
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("idPersona") int idPersona, CreatePersonRequest createPersonRequest) {
        return personService.updatePerson(idPersona, createPersonRequest);
    }
}
