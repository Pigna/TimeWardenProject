package controller;

import model.control.NewUserCountInterceptor;
import model.logic.User;
import model.service.UserService;

import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class UserResource {
	//Newuser
	//GetUser
	//GetUsersFromCompany

	@Inject
	UserService userService;

	@GET
	@Path("/{userId}")
	public Response getUserById(@PathParam("userId") int userId){
		User user;
		try {
			user = userService.getUserById(userId);
		}
		catch (Exception ex) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("User does not exists")
					.type(MediaType.TEXT_HTML)
					.build();
		}
		return Response.ok(user).build();
	}

	@POST
	@Path("/new")
	@Interceptors(NewUserCountInterceptor.class)
	public Response postNewCompany(User newUser){
		try{
			User createdUser = userService.newUser(newUser);
			return Response.status(201).entity(createdUser).build();
		}
		catch (Exception ex) {
			return Response.status(400).build();
		}
	}
}
