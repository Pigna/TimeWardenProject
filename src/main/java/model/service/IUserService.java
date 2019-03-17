package model.service;

import model.control.NewUserCountInterceptor;
import model.logic.User;

import javax.interceptor.Interceptors;
import java.util.ArrayList;

public interface IUserService {

	User getUserById(int userId);

	@Interceptors(NewUserCountInterceptor.class)
	User newUser(User user);

	ArrayList<User> getUsers();

	ArrayList<User> Users();
}
