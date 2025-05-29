package web;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.ItProvisionService;
import web.model.ItProvisionResponse;

import java.util.List;

@Path("it-provision")
@DenyAll
public class ItProvisionResource {
    private final ItProvisionService itProvisionService;

    public ItProvisionResource(ItProvisionService itProvisionService) {
        this.itProvisionService = itProvisionService;
    }

    @GET
    @RolesAllowed({"Admin", "Requester", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ItProvisionResponse> getItProvisions() {
        return itProvisionService.getAllItProvisions();
    }
}
