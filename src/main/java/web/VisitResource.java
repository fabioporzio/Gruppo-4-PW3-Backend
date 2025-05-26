package web;

import data.model.Visit;
import io.vertx.ext.auth.impl.jose.JWT;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import service.VisitService;
import web.model.CreateVisitRequest;

@Path("/visit")
@DenyAll
public class VisitResource {

    private final VisitService visitService;
    private final JsonWebToken jwt;

    public VisitResource(VisitService visitService, JsonWebToken jwt) {
        this.visitService = visitService;
        this.jwt = jwt;
    }

    @POST
    @RolesAllowed({"Admin", "Reqeuster"})
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
    @RolesAllowed({"Admin", "Reqeuster"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateVisit(@PathParam("idVisita") int idVisita, CreateVisitRequest createVisitRequest) {
        Visit visit = visitService.updateVisit(idVisita, createVisitRequest);

        if (visit != null) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @RolesAllowed({"Admin", "Reqeuster", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getVisit(@QueryParam("id") Integer id) {
        if(!jwt.getGroups().contains("Requester") && id == null)
        {
            return Response.ok(visitService.getAllVisits()).build();
        }
        return Response.ok(visitService.getVisitsByPerson(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteVisit(@PathParam("id") Integer id) {
        boolean deleted = visitService.deleteVisit(id);
        return Response.ok(deleted).build();
    }
}
