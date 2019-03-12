package controller;

import model.logic.Company;
import model.service.CompanyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/company")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
public class CompanyResource {

	@Inject
	CompanyService companyService;

	@GET
	@Path("/id/{companyId}")
	public Response getCompanyByName(@PathParam("companyId") int companyId){
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
}
