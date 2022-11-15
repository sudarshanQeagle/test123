package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class SetUp {

	
	@Before
	public void preConditions() {
		
		RestAssured.baseURI="https://dev116902.service-now.com/api/now/table/";
		RestAssured.authentication=RestAssured.basic("admin","Leaf@1234");
	}
}
