package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/task")
public class TaskResource {
	@GET
	@Path("/task/{taskId}")
	public void getTaskById(@PathParam("taskId") int taskId){


	}
}
