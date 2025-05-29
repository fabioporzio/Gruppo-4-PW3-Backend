package web;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.UserService;
import web.model.CreateUserRequest;
import web.model.UserResponse;

import java.util.List;

@Path("/user")
@DenyAll
public class UserResource {

    private final UserService userService;

    public UserResource(final UserService userService) {
        this.userService = userService;
    }

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @POST
    @Path("/add")
    @RolesAllowed("Admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse addUser(CreateUserRequest user) {
        return userService.createUser(user);
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Admin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, CreateUserRequest user) {
        boolean modify = userService.updateUser(id, user);
        if (modify) {
            return Response.ok(true).build();
        }
        return Response.ok(false).build();
    }

}
