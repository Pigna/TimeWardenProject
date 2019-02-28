package controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;

public class UserResourceTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(UserResource.class);
	}

	@Test
	public void userPathParamTest() {
		String response = target("user/user/1").request().get(User.class);
		Assert.assertTrue("userId: 1".equals(response));
	}

}
