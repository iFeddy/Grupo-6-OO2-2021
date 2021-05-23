package com.unla.app.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Role {

	//private long id;
	
	@NotEmpty
	@Size(min=5 ,max=30)
	private String description;
	
	@NotEmpty
	@Size(min=5 ,max=24)
	private String name;
	
	public Role() {}
	
}
