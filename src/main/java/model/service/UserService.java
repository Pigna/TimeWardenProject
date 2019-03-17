package model.service;

import model.logic.User;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Stateless
@ManagedBean
@Named(value="userService")
public class UserService implements IUserService, Serializable {

	public ArrayList<User> Users() {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("Myron"));
		users.add(new User("Anita"));
		users.add(new User("Will"));
		return users;
	}

	@Override
	public User getUserById(int userId) {
		return null;
	}

	@Override
	public User newUser(User user) {
		return null;
	}

	@Override
	public ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("Myron"));
		users.add(new User("Anita"));
		users.add(new User("Will"));
		return users;
	}
}
