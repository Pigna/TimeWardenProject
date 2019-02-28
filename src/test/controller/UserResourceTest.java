package controller;

import model.logic.User;
import model.service.UserService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserResourceTest extends JerseyTest {

	private UserService mockService = mock(UserService.class);

	@Override
	protected Application configure() {
		return new ResourceConfig(UserResource.class)
				.register(new AbstractBinder() {
				@Override
				protected void configure() {
					bind(mockService).to(UserService.class);
				}
				});
	}



	@Test
	public void userPathParamTest() {
		when(mockService.getUserById(1)).thenReturn(new User());

		Response response = target("user/1").request().get();
		//int id = response.readEntity(int.class);
		//Logger.getAnonymousLogger().log(Level.INFO, response+ "");
		//Assert.assertTrue("".equals(.));
		//Assert.assertEquals(response.readEntity(User.class));
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());

	}

}
