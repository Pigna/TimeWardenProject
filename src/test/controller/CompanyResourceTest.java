package controller;

import model.logic.Company;
import model.logic.User;
import model.service.CompanyService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

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
		return new ResourceConfig(CompanyResource.class)
				.register(new AbstractBinder() {
					@Override
					protected void configure() {
						bind(mockService).to(CompanyService.class);
					}
				});
	}

	@Test
	public void getCompanyByIdPathParamTest() {
		when(mockService.getCompanyById(1)).thenReturn(new Company());

		Response response = target("company/id/").request().get();
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void getCompanyByNamePathParamTest() {
		when(mockService.getCompanyByName("byName")).thenReturn(new Company("byName", new User()));

		Response response = target("company/byName").request().get();
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void newCompanyPathParamTest() {
		when(mockService.newCompany("bedrijf", new User())).thenReturn(new Company("bedrijf", new User()));

		Response response = target("company/new").request().post(Entity.json(new Company("bedrijf", new User())));
		Assert.assertEquals("Http response should be 201.", Response.Status.CREATED.getStatusCode(), response.getStatus());
	}

	@Test
	public void addUserToCompanyPathParamTest() {
		Response response = target("company/1/addUser").request().post(Entity.json(new User("addedToCompany")));
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void archiveUserInCompanyPathParamTest() {
		Response response = target("company/1/archive").request().post(Entity.json(new User("archiveMe")));
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void getUsersFromCompanyPathParamTest() {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("userList1"));
		userList.add(new User("userList2"));
		when(mockService.getUsersFromCompany(1)).thenReturn(userList);

		Response response = target("company/id/1/users").request().get();
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void getUsersFromCompanyNamePathParamTest() {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("userList1"));
		userList.add(new User("userList2"));
		when(mockService.getUsersFromCompany("companyName")).thenReturn(userList);

		Response response = target("company/companyName/users").request().get();
		Assert.assertEquals("Http response should be 200.", Response.Status.OK.getStatusCode(), response.getStatus());
	}
}
