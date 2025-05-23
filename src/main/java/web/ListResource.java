package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.model.Person.Person;
import jakarta.annotation.security.RolesAllowed;
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

    private final Map map;
    private final List list;
    private ListService listService;

    public ListResource(ListService listService, Map map, List list) {
        this.listService = listService;
        this.map = map;
        this.list = list;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCountAndListPeopleInCompany() {
        Map<String, Integer> mapCountPeopleInCompany = new HashMap<>();

        mapCountPeopleInCompany.put("Employees", listService.getCountPeopleInCompany());
        mapCountPeopleInCompany.put("Visitors", listService.getCountVisitorInCompany());
        mapCountPeopleInCompany.put("Mainetance", listService.getCountMainetanceInCompany());
        mapCountPeopleInCompany.put("LunchArea", listService.getCountPeopleLaunchArea());
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
        mapPeopleInCompany.put("Mainetance", listService.getMainetanceInCompany());

        return Response.ok(mapPeopleInCompany).build();
    }

}
