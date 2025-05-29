package web;

import data.model.Badge;
import data.model.Visit;
import io.vertx.ext.auth.impl.jose.JWT;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import service.BadgeAssignmentService;
import service.BadgeService;
import service.VisitService;
import web.model.CreateBadgeRequest;
import web.model.CreateVisitRequest;
import web.model.VisitResponse;
import web.model.createPerson.CreatePersonRequest;

import java.time.LocalDate;
import java.util.List;

@Path("/visit")
@DenyAll
public class VisitResource {

    private final BadgeService badgeService;
    private final VisitService visitService;
    private final JsonWebToken jwt;
    private final BadgeAssignmentService badgeAssignmentService;

    public VisitResource(BadgeService badgeService, VisitService visitService, JsonWebToken jwt, BadgeAssignmentService badgeAssignmentService) {
        this.badgeService = badgeService;
        this.visitService = visitService;
        this.jwt = jwt;
        this.badgeAssignmentService = badgeAssignmentService;
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
    @RolesAllowed({"Admin", "Requester", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getVisit(@QueryParam("id") Integer id) {
        if( id == null)
        {
            return Response.ok(visitService.getAllVisits()).build();
        }
        return Response.ok(visitService.getVisitsByPerson(id)).build();
    }

    @GET
    @Path("/by-date/{idResponsabile}")
    @RolesAllowed({"Admin", "Requester", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<VisitResponse> getVisitsByPersonAndDate(
            @PathParam("idResponsabile") int idResponsabile,
            @QueryParam("fromDate") LocalDate fromDate
    ) {
        if (fromDate == null) {
            fromDate = LocalDate.now();
        }
        LocalDate toDate = LocalDate.now().plusDays(7);

        return visitService.getVisitsByPersonAndDate(idResponsabile, fromDate, toDate);
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

    @POST
    @Path("/start_visit")
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startVisit(CreatePersonRequest personRequest) {
        Badge badge = badgeService.assignBadge(personRequest);
        badgeAssignmentService.createBadgeAssignment(badge);
        return Response.ok(badge).build();
    }

    @POST
    @Path("/end_visit")
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endVisit(CreateBadgeRequest badgeRequest) {
        return Response.ok(badgeService.removeBadge(badgeRequest)).build();
    }
}
