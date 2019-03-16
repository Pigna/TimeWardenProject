package model.logic;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
public class Company implements Serializable {

	@NotNull(message = "Name cannot be null")
	private String name;

	@NotNull(message = "Creator cannot be null")
	private User creator;

	ArrayList<Task> tasks;

	public String getName() {
		return name;
	}

	public User getCreator() {
		return creator;
	}

	public Company() {

	}
	public Company(String name, User creator) {
		this.name = name;
		this.creator = creator;
	}
}
