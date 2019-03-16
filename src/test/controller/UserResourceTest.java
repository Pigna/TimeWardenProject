package controller;

import model.logic.User;
import model.service.UserService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserResourceTest extends JerseyTest {

	private UserService mockService = mock(UserService.class);
	ValidatorFactory factory;
	Validator validator;

	@Override
	protected Application configure() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		return new ResourceConfig(UserResource.class)
				.register(new AbstractBinder() {
				@Override
				protected void configure() {
					bind(mockService).to(UserService.class);
				}
				});
	}



	@Test
	public void getUserPathParamTest() {
		when(mockService.getUserById(1)).thenReturn(new User());

		Response response = target("user/1").request().get();
		//int id = response.readEntity(int.class);
		//Logger.getAnonymousLogger().log(Level.INFO, response+ "");
		//Assert.assertTrue("".equals(.));
		//Assert.assertEquals(response.readEntity(User.class));
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());

		//Validate the returned user, gives message because user was created without name;
		Set<ConstraintViolation<User>> violations = validator.validate(response.readEntity(User.class));
		for (ConstraintViolation<User> violation : violations) {
			Logger.getAnonymousLogger().log(Level.INFO, violation.getMessage());
		}

	}

	@Test
	public void newUserPathParamTest() {
		when(mockService.newUser(new User())).thenReturn(new User());

		Response response = target("user/new").request().post(Entity.json(new User("newUser")));
		Assert.assertEquals("Http response should be 201.", Response.Status.CREATED.getStatusCode(), response.getStatus());
	}
}
