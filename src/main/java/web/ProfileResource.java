package web;

import data.repository.PersonRepository;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import service.PersonService;

@Path("/profile")
@DenyAll
public class ProfileResource {
    private final PersonService personService;
    private final JsonWebToken jwtToken;

    public ProfileResource(PersonService personService, JsonWebToken jwtToken) {
        this.personService = personService;
        this.jwtToken = jwtToken;
    }

    @GET
    @RolesAllowed({"Admin", "Requester", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getProfile() {
        return Response.ok(personService.getPersonById(Integer.parseInt(jwtToken.getClaim("id").toString()))).build();
    }

}
