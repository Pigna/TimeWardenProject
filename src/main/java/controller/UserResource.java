package controller;

import model.logic.User;
import model.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	//Newuser
	//GetUser
	//GetUsersFromCompany

	@Inject
	UserService userService;

	@GET
	@Path("/{userId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
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
}
