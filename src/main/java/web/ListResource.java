package web;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import data.model.Person.Person;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;
import service.ListService;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/list")
@DenyAll
public class ListResource {

    private final ListService listService;

    @Inject
    public ListResource(ListService listService) {
        this.listService = listService;
    }

    @GET
    @Path("/count")
    @RolesAllowed({"Admin", "Reception"})
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
    @RolesAllowed({"Admin", "Reception"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPeopleInCompany() {
        Map<String, List<Person>> mapPeopleInCompany = new HashMap<>();

        mapPeopleInCompany.put("Employees", listService.getPeopleInCompany());
        mapPeopleInCompany.put("Visitors", listService.getVisitorInCompany());
        mapPeopleInCompany.put("Maintenance", listService.getMaintenanceInCompany());

        return Response.ok(mapPeopleInCompany).build();
    }

    @GET
    @Path("/pdf")
    @Produces("application/pdf")
    @RolesAllowed({"Admin", "Reception"})
    public Response getPdf() {
        Map<String, List<Person>> mapPeopleInCompany = new HashMap<>();

        mapPeopleInCompany.put("Employees", listService.getPeopleInCompany());
        mapPeopleInCompany.put("Visitors", listService.getVisitorInCompany());
        mapPeopleInCompany.put("Maintenance", listService.getMaintenanceInCompany());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();
            document.add(new Paragraph("PDF PERSONE PRESENTI"));
            document.add(new Paragraph("Dipendenti: \n" + listService.getPeopleInCompany().toString() +
                    "\n Visitatori: \n" + listService.getVisitorInCompany().toString() +
                    "\n Manutentori: \n" + listService.getMaintenanceInCompany().toString()));
            document.close();

        } catch (DocumentException e) {
            return Response.serverError().entity("Errore nella generazione PDF").build();
        }

        StreamingOutput stream = (OutputStream output) -> {
            baos.writeTo(output);
            output.flush();
        };

        return Response.ok(stream)
                .header("Content-Disposition", "attachment; filename=\"documento.pdf\"")
                .build();
    }

}