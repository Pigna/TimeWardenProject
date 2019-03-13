package model.service;

import model.logic.User;

public interface UserService {

	User getUserById(int userId);

	User newUser(User user);
}
