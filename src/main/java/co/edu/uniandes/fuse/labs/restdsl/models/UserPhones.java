package co.edu.uniandes.fuse.labs.restdsl.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model of User Phones")
public class UserPhones {

	@JsonProperty
	private String officePhone;
	@JsonProperty
	private String homePhone;
	@JsonProperty
	private String mobilePhone;
	
	@ApiModelProperty(value = "The office phone", required = false, example = "444 123 456")
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	@ApiModelProperty(value = "The home phone", required = false, example = "300 123 456")
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	@ApiModelProperty(value = "The mobile phone", required = false, example = "300 123 45456")
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
}
