package model.logic;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

	@NotNull(message = "Name cannot be null")
	String name;

	@Past
	Date birthdate;

	@Email(message = "Email should be valid")
	String Email;

	ArrayList<Account> accounts;

	public User () {

	}
	public User (String name) {
		this.name = name;
	}
}
