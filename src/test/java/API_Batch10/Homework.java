package API_Batch10;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Homework {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://api.github.com";
	}

	@Test
	public void userTest() {

		RestAssured.given().pathParam("username", "avanalitekin").get("/users/{username}").then().log().all();

	}
}
