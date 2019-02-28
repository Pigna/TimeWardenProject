package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/company")
public class CompanyResource {

	@GET
	@Path("/company/{companyName}")
	public void getCompanyByName(@PathParam("companyName") String company){


	}
}
