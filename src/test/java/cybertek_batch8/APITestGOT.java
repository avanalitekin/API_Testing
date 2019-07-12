package cybertek_batch8;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//THIS IS NO LONGER VALID, RESPONSE USED TO BE IN JSON FORMAT, NOW IT IS IN HTML FORMAT

public class APITestGOT {
		
	@Test
	public void testGOT() {
		Response response=RestAssured.given()
				.contentType(ContentType.JSON)
				.relaxedHTTPSValidation()
				.get("https://api.got.show/api/continents");
		String hmlString=response.asString();
		System.out.println(hmlString);
	}
}
