package controller;

import model.logic.Company;
import model.logic.User;
import model.service.CompanyService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/company")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class CompanyResource {

	@Inject
	CompanyService companyService;

	@GET
	@Path("/id/{companyId}")
	public Response getCompanyById(@PathParam("companyId") int companyId){
		Company company;
		try {
			company = companyService.getCompanyById(companyId);
		}
		catch (Exception ex) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Company does not exists")
					.type(MediaType.TEXT_HTML)
					.build();
		}
		return Response.ok(company).build();
	}

	@GET
	@Path("/{companyName}")
	public Response getCompanyByName(@PathParam("companyName") String companyName){
		Company company;
		try {
			company = companyService.getCompanyByName(companyName);
		}
		catch (Exception ex) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Company does not exists")
					.type(MediaType.TEXT_HTML)
					.build();
		}
		return Response.ok(company).build();
	}

	@POST
	@Path("/new")
	public Response postNewCompany(Company newCompany){
		try{
			Company createdCompany = companyService.newCompany(newCompany.getName(), newCompany.getCreator());
			return Response.status(201).entity(createdCompany).build();
		}
		catch (Exception ex) {
			return Response.status(400).build();
		}
	}

	@POST
	@Path("/{companyId}/addUser")
	public Response postAddUserToCompany(@PathParam("companyId") int companyId, User user){
		try{
			companyService.addUserToCompany(user, companyId);
			return Response.status(200).build();
		}
		catch (Exception ex) {
			return Response.status(400).build();
		}
	}

	@POST
	@Path("/{companyId}/archive")
	public Response postArchiveUserInCompany(@PathParam("companyId") int companyId, User user){
		try{
			companyService.archiveUserInCompany(user, companyId);
			return Response.status(200).build();
		}
		catch (Exception ex) {
			return Response.status(400).build();
		}
	}

	@GET
	@Path("/{companyName}/users")
	public Response getUsersFromCompany(@PathParam("companyName") String companyName){
		ArrayList<User> users;
		try {
			users = companyService.getUsersFromCompany(companyName);
		}
		catch (Exception ex) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Company does not exists")
					.type(MediaType.TEXT_HTML)
					.build();
		}
		return Response.ok(users).build();
	}

	@GET
	@Path("/id/{companyId}/users")
	public Response getUsersFromCompany(@PathParam("companyId") int companyId){
		ArrayList<User> users;
		try {
			users = companyService.getUsersFromCompany(companyId);
		}
		catch (Exception ex) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Company does not exists")
					.type(MediaType.TEXT_HTML)
					.build();
		}
		return Response.ok(users).build();
	}
}
//@Consumes({MediaType.APPLICATION_JSON})