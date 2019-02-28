package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/shift")
public class ShiftResource {
	@GET
	@Path("/shift/{shiftId}")
	public void getShiftById(@PathParam("shiftId") int shiftId){


	}
}
