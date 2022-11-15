package steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinition {
	
	Response response;
	@Given("set baseUri")
	public void setBaseUri()
	{
		RestAssured.baseURI="https://dev116902.service-now.com/api/now/table";
	}
	
	@And("set Authentication")
	public void setAuthentication()
	{
		RestAssured.authentication=RestAssured.basic("admin", "Leaf@1234");
	}
	
	@When("Get All incidents")
	public void getAllincidents()
	{
		 response = RestAssured.get("/incident");
	}
	
	@When("Get All incidents with QP {string} as {string}")
	public void getIncidentsWithQP(String key,String value)
	{
		response=RestAssured.given().queryParam(key, value).get("/incident");
	}
	
	@When("Create Incident with multiple files {string}")
	public void createIncidentFile(String fileName) {
		
		response=RestAssured.given().contentType("application/json").when().body(new File("./src/main/resources/"+fileName)).post("/incident");
	}
	
	@Then("verify status code as {int}")
	public void verifyStatusCode(int StatusCOde)
	{
		response.then().statusCode(StatusCOde);
	}
	
	@And("print the response")
	public void printResponse()
	{
		response.prettyPrint();
	}

}
