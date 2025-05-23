package web;

import data.model.Visit;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.VisitService;
import web.model.CreateVisitRequest;

@Path("/visit")
@DenyAll
public class VisitResource {

    private final VisitService visitService;

    public VisitResource(VisitService visitService) {
        this.visitService = visitService;
    }

    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVisit(CreateVisitRequest createVisitRequest) {
        Visit visit = visitService.addVisit(createVisitRequest);

        if (visit != null) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{idVisita}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateVisit(@PathParam("idVisita") int idVisita, CreateVisitRequest createVisitRequest) {
        Visit visit = visitService.updateVisit(idVisita, createVisitRequest);

        if (visit != null) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
