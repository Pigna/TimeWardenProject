package controller;

import model.service.ShiftService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;

import static org.mockito.Mockito.mock;

public class ShiftResourceTest extends JerseyTest {

	private ShiftService mockService = mock(ShiftService.class);

	@Override
	protected Application configure() {
		return new ResourceConfig(ShiftService.class)
				.register(new AbstractBinder() {
					@Override
					protected void configure() {
						bind(mockService).to(ShiftService.class);
					}
				});
	}

//	get shift
//	get shifts from person
//	get shifts from company
//	get shifts from week
//	get shifts from month
//	get shifts
}
