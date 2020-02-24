package co.edu.uniandes.fuse.labs.restdsl;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;

import co.edu.uniandes.fuse.labs.restdsl.beans.UserService;
import co.edu.uniandes.fuse.labs.restdsl.models.*;
import co.edu.uniandes.fuse.labs.restdsl.processors.*;

public class routeBuilder extends RouteBuilder {

	public String version = "2.0.0";

	@Override
	public void configure() throws Exception {
		
		/**
		 * DATA FORMATS
		 */
		
		JacksonDataFormat jsonDFUser = new JacksonDataFormat(User.class);
		jsonDFUser.setPrettyPrint(true);
		
		JacksonDataFormat jsonDFUser_Req = new JacksonDataFormat(User_Req.class);
		jsonDFUser_Req.setPrettyPrint(true);
		
		JacksonDataFormat jsonDFResponseStructure = new JacksonDataFormat(ResponseStructure.class);
		jsonDFResponseStructure.setPrettyPrint(true);
	
		/**
		 * EXCEPTIONS 
		 */
		//A simple change de sebastian
		onException(Exception.class)
		 	.handled(true)
		    .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
		    .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		    .setBody().simple("${exception.message}");
			
		 restConfiguration()
		    .component("netty4-http")
		    .bindingMode(RestBindingMode.off) //Off para evitar conflictos con los data formats
		    .host("localhost")
		    .port("9090")
		    .contextPath("/restDSL/api/v"+version)
		    .apiContextPath("/doc")
		    .apiContextRouteId("doc")
		         .apiProperty("api.title", "User API")
		         .apiProperty("api.version", version)
		         .apiProperty("cors", "true");

		rest("/example").description("Example rest service")
			.get("/user/{type}/{document}").description("Find a user by type and document")
				.consumes("application/json").produces("application/json")
				.param().name("type").required(true).description("The type of the user").defaultValue("CC").dataType("string").endParam()
				.param().name("document").required(true).description("The document of the user").defaultValue("1234567").dataType("integer").endParam()
				.outType(User.class)
				.to("direct:find")
			.post("/user").description("Update a user")
				.type(User_Req.class)
				.consumes("application/json").produces("application/json")
				.outType(User.class)
				.to("direct:update")
			.put("/user").description("Insert a user")
				.type(User.class)
				.consumes("application/json").produces("application/json")
				.outType(User.class)
				.to("direct:insert")
			.delete("/user/{id}").description("Delete a user")
				.consumes("application/json").produces("application/json")
				.param().name("id").required(true).description("The Id of the user").defaultValue("123456").dataType("integer").endParam()
				.outType(ResponseStructure.class)
				.to("direct:delete")
		;
				
		from("direct:find")
		.bean(UserService.class, "getUser")
		.marshal(jsonDFUser)
		.log("${body}");
		
		from("direct:update")
		.unmarshal(jsonDFUser)
		.process(new UserProcessor())
		.bean(UserService.class, "updateUser")
		.marshal(jsonDFUser)
		.log("${body}");
		
		from("direct:insert")
		.unmarshal(jsonDFUser_Req)
		.bean(UserService.class, "insertUser")
		.marshal(jsonDFUser)
		.log("${body}");
		
		from("direct:delete")
		.bean(UserService.class, "deleteUser")
		.marshal(jsonDFResponseStructure)
		.log("${body}");
		
	}
}
