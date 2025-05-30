package web;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.event.Reception;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.PersonService;
import web.model.createPerson.CreatePersonRequest;
import web.model.createPerson.CreatePersonResponse;

import java.util.List;

@Path("/people")
@DenyAll
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @RolesAllowed({"Admin", "Reception", "Requester"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<CreatePersonResponse> getAllPeople() {
        return personService.getAllPeople();
    }

    @GET
    @Path("/{idPersona}")
    @RolesAllowed({"Admin", "Reception", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    public CreatePersonResponse getPerson(@PathParam("idPersona") int idPersona) {
        return personService.getPersonById(idPersona);
    }

    @GET
    @Path("/get-person-by-user/{idUser}")
    @RolesAllowed({"Admin", "Reception", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    public CreatePersonResponse getPersonByUser(@PathParam("idUser") int idUser) {
        return personService.getPersonByUser(idUser);
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

    @DELETE
    @Path("/{idPersona}")
    @RolesAllowed({"Admin", "Reception"})
    public Response deletePerson(@PathParam("idPersona") int idPersona) {
        return Response.ok(personService.deletePersonById(idPersona)).build();
    }

}
