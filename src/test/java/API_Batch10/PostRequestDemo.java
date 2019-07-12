package API_Batch10;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import static org.hamcrest.MatcherAssert.*;

import utilities.BookItUtility;

public class PostRequestDemo {

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";
	}

	@Test
	public void getToken() {
		String teamName = new Faker().team().name();
		System.out.println(teamName);
		String token = BookItUtility.getTeacherToken();

		RestAssured.given()
		.log().all()
		.header("Authorization", token)
		.queryParam("campus-location", "VA")
		.queryParam("batch-number", "8")
		.queryParam("team-name", teamName).when()
		.post("/api/teams/team")
		.then()
		.statusCode(201)
//		.body(containsString("added"))
		.log().all();
	}
}
