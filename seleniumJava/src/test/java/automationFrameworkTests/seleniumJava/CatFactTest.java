package automationFrameworkTests.seleniumJava;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.InitializationB;

public class CatFactTest extends InitializationB{
	
	@BeforeTest
	public void init() throws IOException
	{
		//Initialize the driver and go to url
		driver = initializeBrowser();
	}
	
	@Test
	public void catFact(){
		
		// Specify the base URL to the RESTful web service
		 RestAssured.baseURI = "https://cat-fact.herokuapp.com";
		 
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a request to the server by specifying the method Type and the method URL.
		 // This will return the Response from the server. Store the response in a variable.
		 Response response = httpRequest.request(Method.GET, "/facts/random?animal_type=cat&amount=2");
		 
		 // Now let us print the body of the message to see what response
		 // we have recieved from the server
		 String responseBody = response.getBody().asString();
		 Assert.assertNotNull(responseBody, "Body is empty");
		 System.out.println("Response Body is =>  " + responseBody);
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
