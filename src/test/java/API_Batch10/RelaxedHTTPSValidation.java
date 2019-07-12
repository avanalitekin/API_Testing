package API_Batch10;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RelaxedHTTPSValidation {
  @Test
  public void releaxedYo() {
	  RestAssured.useRelaxedHTTPSValidation();
	  RestAssured.given()
//	  .relaxedHTTPSValidation()//connection will be declined by our machine since their SSL certificate expired unless we use relaxedHTTPSValidation()
	  .get("https://untrusted-root.badssl.com/")
	  .then()
	  .log()
	  .all()
	  .statusCode(200);
	  
  }
}
