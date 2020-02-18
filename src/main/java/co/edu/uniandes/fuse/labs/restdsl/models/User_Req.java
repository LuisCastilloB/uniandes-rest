package co.edu.uniandes.fuse.labs.restdsl.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User_Req extends User {

	@JsonIgnore
	private Integer id;
	
}
