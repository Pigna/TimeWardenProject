package model.logic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Company implements Serializable {
	private String name;
	private User creator;

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
