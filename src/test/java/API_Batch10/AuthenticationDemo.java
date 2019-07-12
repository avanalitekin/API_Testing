package API_Batch10;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AuthenticationDemo {
//  @Test
  public void authenticationWithAPIKeyNegative() {
	  RestAssured.given()
	  .log().all()
	  .queryParam("t", "Kung Fury")
//	  .queryParam("apikey", "6568d003")
	  .get("http://www.omdbapi.com")
	  .then()
	  .log().all()
	  .statusCode(401);
  }
  
//  @Test
  public void authenticationWithAPIKeyPositive() {
	  RestAssured.given()
	  .log().all()
	  .queryParam("t", "Kung Fury")
	  .queryParam("apikey", "6568d003")
	  .get("http://www.omdbapi.com")
	  .then()
	  .log().all()
	  .statusCode(200);
  }
  
//  @Test
  public void basicAuthenticationNeg() {
	  RestAssured.given()
	  .log().all()
	  .get("https://the-internet.herokuapp.com/basic_auth")
	  .then()
	  .log().all()
	  .statusCode(401);
  }
  
  @Test
  public void basicAuthenticationPos() {
	  RestAssured.given()
	  .auth().basic("admin", "admin")
	  .log().all()
	  .get("https://the-internet.herokuapp.com/basic_auth")
	  .then()
	  .log().all()
	  .statusCode(200);
  }
}
