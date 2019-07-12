package cybertek_batch8;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ResponseManipulation {
	
	 @BeforeClass
	  public void beforeClass() {
		  RestAssured.baseURI="https://avanalitekin.dev.cc/";
		  RestAssured.basePath="wp-json/wp/v2/";	
	  }
	 
//	 @Test
	 public void test_JSONPath() {
		 Response response=RestAssured.given()
				  .auth().preemptive().basic("avanalitekin", "3mersule")
				  .relaxedHTTPSValidation()
				  .when()
				  .log().all()
				  .get("users");
		 System.out.println(response.asString());
		 response.prettyPrint();
		 
		 JsonPath jp=response.jsonPath();
		 List<Map<String,String>> all = jp.get("");
		 System.out.println(all.size());
		 
		 System.out.println(jp.get("name"));
		 System.out.println(jp.get("id"));
		 System.out.println(jp.get("link"));
	 
	 }
	 
	 @Test
	 public void driverInfoTest() {
		 Response response =RestAssured.given()
				 .relaxedHTTPSValidation()
				 .log().all()
				 .get("http://ergast.com/api/f1/drivers.json");
		 JsonPath jp=response.jsonPath();
		 String nameActual=jp.get("MRData.DriverTable.Drivers[1].givenName");
		 System.out.println(nameActual);
		 String nameExpected="george";
		 Assert.assertThat(nameActual, Matchers.equalToIgnoringCase(nameExpected));
	 }
	 

}
