package model.service;

import model.control.NewUserCountInterceptor;
import model.logic.User;

import javax.interceptor.Interceptors;

public interface UserService {

	User getUserById(int userId);

	@Interceptors(NewUserCountInterceptor.class)
	User newUser(User user);
}
