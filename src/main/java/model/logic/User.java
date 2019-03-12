package model.logic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {
	String name;

	public User () {

	}
	public User (String name) {
		this.name = name;
	}
}
