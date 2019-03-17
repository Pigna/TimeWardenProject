package model.service;

import model.logic.Company;
import model.logic.User;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.ArrayList;

@Stateless
@ManagedBean
public class CompanyService implements ICompanyService, Serializable {
	@Override
	public Company getCompanyById(int i) {
		return null;
	}

	@Override
	public Company getCompanyByName(String byName) {
		return null;
	}

	@Override
	public Company newCompany(String name, User user) {
		return null;
	}

	@Override
	public void addUserToCompany(User user, int companyId) {

	}

	@Override
	public void archiveUserInCompany(User user, int companyId) {

	}

	@Override
	public ArrayList<User> getUsersFromCompany(int companyId) {
		return null;
	}

	@Override
	public ArrayList<User> getUsersFromCompany(String companyName) {
		return null;
	}
}
