package controller;

import model.service.ITaskService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;

import static org.mockito.Mockito.mock;

public class TaskResourceTest extends JerseyTest {

	private ITaskService mockService = mock(ITaskService.class);

	@Override
	protected Application configure() {
		return new ResourceConfig(ITaskService.class)
				.register(new AbstractBinder() {
					@Override
					protected void configure() {
						bind(mockService).to(ITaskService.class);
					}
				});
	}

//	get task by id
//	get tasks from company
//	add task
//	remove task
//	edit task
}
