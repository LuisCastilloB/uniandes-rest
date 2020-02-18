package co.edu.uniandes.fuse.labs.restdsl.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model of User")
public class ResponseStructure {

	@JsonProperty
	private String status;
	@JsonProperty
	private String message;
	
	@ApiModelProperty(value = "The status of response", required = true, example = "OK")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@ApiModelProperty(value = "The description of response", required = true, example = "Example of description")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
