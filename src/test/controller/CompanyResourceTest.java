package controller;

import model.logic.User;
import model.service.CompanyService;
import model.service.UserService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CompanyResourceTest extends JerseyTest {
	//get company by id
	//create company
	//add user to company
	//archive user

	//get users from company

	private CompanyService mockService = mock(CompanyService.class);

	@Override
	protected Application configure() {
		return new ResourceConfig(CompanyService.class)
				.register(new AbstractBinder() {
					@Override
					protected void configure() {
						bind(mockService).to(CompanyService.class);
					}
				});
	}

	@Test
	public void getCompanyPathParamTest() {
		when(mockService.getCompanyById(1)).thenReturn(new Company());

		Response response = target("company/1").request().get();
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void newCompanyPathParamTest() {
		when(mockService.newCompany()); //TODO: then?

		Response response = target("company").request().post(Entity.json(new Company()));  //@Consumes(MediaType.APPLICATION_JSON)
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void addUserToCompanyPathParamTest() {
		when(mockService.addUserToCompany(1,1));//TODO: then?

		Response response = target("company/1/addUser/1").request().post(new User()); //To company 1 add user 1
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void archiveUserInCompanyPathParamTest() {
		when(mockService.archiveUserInCompany(1,1));//TODO: then?

		Response response = target("company/1/archive/1").request().get();
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void getUsersFromCompanyPathParamTest() {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User());
		when(mockService.usersFromCompany(1)).thenReturn(userList);

		Response response = target("company/1/users").request().get();
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}
}
