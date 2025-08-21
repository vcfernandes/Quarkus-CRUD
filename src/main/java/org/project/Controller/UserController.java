package org.project.Controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.project.Entity.UserEntity;
import org.project.Service.UserService;

import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Transactional
    public Response CreateUser(UserEntity userEntity) {
        return Response.ok(userService.CreateUser(userEntity)).build();
    }

    @GET
    public Response FindAll(@QueryParam("page") @DefaultValue("0") Integer page,
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var users = userService.FindAll(page, pageSize);
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response GetById(@PathParam("id") UUID userId) {
        return Response.ok(userService.findById(userId)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response UpdateUser(@PathParam("id") UUID userId, UserEntity userEntity) {
        return Response.ok(userService.UpdateUser(userId, userEntity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response DeleteById(@PathParam("id") UUID userId) {
        return Response.noContent().build();
    }

}

