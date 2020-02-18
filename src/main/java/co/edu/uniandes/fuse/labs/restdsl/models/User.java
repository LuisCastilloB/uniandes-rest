package co.edu.uniandes.fuse.labs.restdsl.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model of User")
public class User {

	@JsonProperty
	private Integer id;
	@JsonProperty
	private String type;
	@JsonProperty
	private int document;
	@JsonProperty
	private String name;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private UserPhones userPhones;
	
	@ApiModelProperty(value = "The id of user", required = false, example = "1")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ApiModelProperty(value = "The type of document", required = true, example = "CC")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@ApiModelProperty(value = "The document", required = true, example = "1234567")
	public int getDocument() {
		return document;
	}
	public void setDocument(int document) {
		this.document = document;
	}
	@ApiModelProperty(value = "The Name", required = true, example = "Pepe")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ApiModelProperty(value = "The Last Name", required = true, example = "Perez")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@ApiModelProperty(value = "The Phones", required = false)
	public UserPhones getUserPhones() {
		return userPhones;
	}
	
	public void setUserPhones(UserPhones userPhones) {
		this.userPhones = userPhones;
	}
	
	
	
	
	
}
