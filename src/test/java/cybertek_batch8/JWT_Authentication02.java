package cybertek_batch8;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JWT_Authentication02 {
	String token="10960~O6QUlakiScSFLVQvqnRPPYDBLE1rC2V9N7FZfhyxu9ls7bJdMgnYRaJhNRZ49evM";
//  @Test
  public void connectToCyberTekCanvasAPI() {
	  RestAssured.baseURI="https://learn.cybertekschool.com";
	  RestAssured.basePath="/api/v1";
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .auth().oauth2(token)
	  .contentType(ContentType.JSON)
	  .get("/courses/129/modules")
	  .then()
	  .log().all()
	  .statusCode(200)
	  .body("$", Matchers.hasSize(10));
  }
  
  @Test
  public void connectToCyberTekCanvasAPI2() {
	  RestAssured.baseURI="https://learn.cybertekschool.com";
	  RestAssured.basePath="/api/v1";
	  Response response= RestAssured.given()
	  .relaxedHTTPSValidation()
	  .auth().oauth2(token)
	  .contentType(ContentType.JSON)
	  .get("/courses/129/modules");
	  System.out.println(response.jsonPath().get("id"));
	  System.out.println(response.jsonPath().get("id[0]"));
	 List<String> modulesList=response.jsonPath().get();
	 for(int i=0; i<modulesList.size();i++) {
		 String format="%-20s%s%n";
		 System.out.printf(format,"id for module "+(i+1)+": ",response.jsonPath().get("id["+i+"]"));
		 System.out.printf(format,"name for module "+(i+1)+": ",response.jsonPath().get("id["+i+"]"));
	 }
  }
}
