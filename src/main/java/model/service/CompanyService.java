package model.service;

import model.logic.Company;
import model.logic.User;

import java.util.ArrayList;

public interface CompanyService {
	Company getCompanyById(int i);

	Company getCompanyByName(String byName);

	Company newCompany(String name, User user);

	void addUserToCompany(User user, int companyId);

	void archiveUserInCompany(User user, int companyId);

	ArrayList<User> getUsersFromCompany(int companyId);

	ArrayList<User> getUsersFromCompany(String companyName);
}
