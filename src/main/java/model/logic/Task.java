package model.logic;

import javax.validation.constraints.NotNull;

public class Task {

	@NotNull(message = "Name cannot be null")
	String name;

	String description;

}
