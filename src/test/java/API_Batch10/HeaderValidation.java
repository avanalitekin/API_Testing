package API_Batch10;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class HeaderValidation {
  @BeforeClass
  public void setUp() {
	  RestAssured.baseURI="https://uinames.com/api";
  }
  
  @Test
  public void headerTest() {
	  RestAssured.given()
	  .when()
	  .get()
	  .then()
	  .log().headers()
	  .header("Server", "Apache")
	  .header("X-Powered-By", "PHP/5.4.45")
	  .header("Access-Control-Allow-Origin", "*")
	  .header("Access-Control-Allow-Methods", "GET")
	  .header("Transfer-Encoding", "chunked")
	  .header("Content-Type", "application/json; charset=utf-8")
	  ;
	 
  }
}
