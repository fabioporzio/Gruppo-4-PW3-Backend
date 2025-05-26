package web;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import service.BadgeRecordService;
import web.model.BadgeRecordHistoryResponse;

import java.util.List;

@Path("/badge-record-history")
@DenyAll
public class BadgeRecordHistoryResource {

    private final BadgeRecordService badgeRecordService;

    public BadgeRecordHistoryResource(BadgeRecordService badgeRecordService) {
        this.badgeRecordService = badgeRecordService;
    }

    @GET
    @Path("/secondo-mona")
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<BadgeRecordHistoryResponse> getBadgeRecordHistoryForSmEmployees() {
        return badgeRecordService.getBadgeRecordHistoryForSmEmployees();
    }

    @GET
    @Path("/visitors")
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<BadgeRecordHistoryResponse> getBadgeRecordHistoryForVisitors() {
        return badgeRecordService.getBadgeRecordHistoryVisitors();
    }

    @GET
    @Path("/lunch-area")
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<BadgeRecordHistoryResponse> getBadgeRecordHistoryOfCanteen() {
        return badgeRecordService.getBadgeRecordHistoryOfLunchArea();
    }
}
