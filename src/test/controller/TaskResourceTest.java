package controller;

import model.service.TaskService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;

import static org.mockito.Mockito.mock;

public class TaskResourceTest extends JerseyTest {

	private TaskService mockService = mock(TaskService.class);

	@Override
	protected Application configure() {
		return new ResourceConfig(TaskService.class)
				.register(new AbstractBinder() {
					@Override
					protected void configure() {
						bind(mockService).to(TaskService.class);
					}
				});
	}

//	get task by id
//	get tasks from company
//	add task
//	remove task
//	edit task
}
