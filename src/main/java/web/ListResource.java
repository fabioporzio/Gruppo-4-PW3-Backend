package web;

import data.model.Person.Person;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.ListService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/list")
public class ListResource {

    private final ListService listService;

    @Inject
    public ListResource(ListService listService) {
        this.listService = listService;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCountAndListPeopleInCompany() {
        Map<String, Integer> mapCountPeopleInCompany = new HashMap<>();

        mapCountPeopleInCompany.put("Employees", listService.getCountPeopleInCompany());
        mapCountPeopleInCompany.put("Visitors", listService.getCountVisitorInCompany());
        mapCountPeopleInCompany.put("Maintenance", listService.getCountMaintenanceInCompany());
        mapCountPeopleInCompany.put("LunchArea", listService.getCountPeopleLunchArea());
        mapCountPeopleInCompany.put("Cigarette", listService.getCountPeopleCigarette());
        mapCountPeopleInCompany.put("Parking", listService.getCountPeopleParking());

        return Response.ok(mapCountPeopleInCompany).build();
    }

    @GET
    @Path("/people")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPeopleInCompany() {
        Map<String, List<Person>> mapPeopleInCompany = new HashMap<>();

        mapPeopleInCompany.put("Employees", listService.getPeopleInCompany());
        mapPeopleInCompany.put("Visitors", listService.getVisitorInCompany());
        mapPeopleInCompany.put("Maintenance", listService.getMaintenanceInCompany());

        return Response.ok(mapPeopleInCompany).build();
    }
}