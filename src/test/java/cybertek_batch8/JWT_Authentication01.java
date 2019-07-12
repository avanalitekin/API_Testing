package cybertek_batch8;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JWT_Authentication01 {
	String token;

	public String getToken() {
		RestAssured.baseURI = "https://www.avanalitekin-api-testing.dev.cc";
		RestAssured.basePath = "/wp-json/jwt-auth/v1";
		Response response = RestAssured.given()
			.relaxedHTTPSValidation()
//			.contentType(ContentType.URLENC)
//			.accept(ContentType.JSON)
			.formParam("username", "avanalitekin")
			.formParam("password", "3mersule")
			.log().all()
			.when()
			.post("/token");
//		.post("https://www.avanalitekin-api-testing.dev.cc/wp-json/jwt-auth/v1/token");

		String tokenString = "Bearer " + response.jsonPath().getString("token");
		System.out.println(tokenString);
		return tokenString;

	}

	@Test
	public void jwt_auth_test() {
		token = getToken();
		RestAssured.baseURI = "https://www.avanalitekin-api-testing.dev.cc";
		RestAssured.basePath = "/wp-json/wp/v2";

		
		String[] roles = { "subscriber", "contributor", "author", "editor" };
		String role = roles[new Random().nextInt(roles.length)];
		String capabilities = "capabilities." + role;

		String user = new Faker().name().username();
		Map<String, String> userToBeAdded = new HashMap<String, String>();
			userToBeAdded.put("username", user);
			userToBeAdded.put("name", user);
			userToBeAdded.put("first_name", user);
			userToBeAdded.put("last_name", user);
			userToBeAdded.put("email", user + "@" + user + ".com");
			userToBeAdded.put("roles", role);
			userToBeAdded.put("password", user);

		RestAssured.given()
			.relaxedHTTPSValidation()
			.header("Authorization", token)
			.header("Content-Type","application/json")
			.log().all()
			.body(userToBeAdded)
			.post("/users")
			.then()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.body(capabilities, Matchers.is(true));
			;
	}
}
