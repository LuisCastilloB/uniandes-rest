package co.edu.uniandes.fuse.labs.restdsl.test;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import co.edu.uniandes.fuse.labs.restdsl.routes.routeBuilder;

public class RouteBuilderTest extends CamelTestSupport {

	@Produce(uri = "http4://localhost:9090/restDSL/api/v2.0.0/example/user/CC/12345678")
	protected ProducerTemplate testProducerGet;
	
	@Produce(uri = "http4://localhost:9090/restDSL/api/v2.0.0/example/user")
	protected ProducerTemplate testProducerPost;
	
	@EndpointInject(uri = "mock:outputGet")
    protected MockEndpoint resultEndpointGet;
	
	@EndpointInject(uri = "mock:outputPost")
    protected MockEndpoint resultEndpointPost;
	

	
	protected RoutesBuilder createRouteBuilder() throws Exception {
		return new routeBuilder();
	}
	
    @Test
    public void testGetUser() throws Exception {
    	
    	resultEndpointGet.expectedHeaderReceived("CamelHttpResponseCode", "200");
    	resultEndpointGet.setExpectedCount(1);
    	
    	testProducerGet.sendBodyAndHeader(null, "CamelHttpMethod", "GET");
    	
    	resultEndpointGet.assertIsSatisfied();
    	
    }
    
    @Test
    public void testPostUser() throws Exception {
    	
    	resultEndpointPost.expectedHeaderReceived("CamelHttpResponseCode", "200");
    	resultEndpointPost.setExpectedCount(1);
    	    	
    	String contents = new String(Files.readAllBytes(Paths.get("src/test/resources/post.json"))); 
    	testProducerPost.sendBodyAndHeader(contents, "CamelHttpMethod", "POST");
    	
    	resultEndpointPost.assertIsSatisfied();
    	
    }

}
