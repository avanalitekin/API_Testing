package utilities;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BookItUtility {
	
  public static String getTeacherToken() {
	
	       Response response= RestAssured.given().log().all().queryParam("email", "teacherva5@gmail.com").
	         queryParam("password","maxpayne").when().
	                get("https://cybertek-reservation-api-qa.herokuapp.com/sign");
	        JsonPath jp= response.jsonPath();
	        String accessToken= jp.get("accessToken");
	        System.out.println("accessToken: \t"+accessToken);
	        String refreshToken= jp.get("refreshToken");
	       System.out.println("refreshToken: \t"+refreshToken);
	       
	       return accessToken;

	  
  }
}
