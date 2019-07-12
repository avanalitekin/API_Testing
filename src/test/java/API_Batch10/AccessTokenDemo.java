package API_Batch10;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AccessTokenDemo {

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI="https://cybertek-reservation-api-qa.herokuapp.com";
	}
	@Test
	public void getTokenTest() {
	
		RestAssured.given().log().all().queryParam("email", "teacherva5@gmail.com")
		.queryParam("password", "maxpayne")
		.get("/sign")
		.then()
		.log().all()
		.statusCode(200);
	}
	
//	@Test
    public void getToken(){
       Response response= RestAssured.given().log().all().queryParam("email", "teacherva5@gmail.com").
                queryParam("password","maxpayne").when().
                get("sign");
        JsonPath jp= response.jsonPath();
        String accessToken= jp.get("accessToken");
        System.out.println("accessToken: \t"+accessToken);
        String refreshToken= jp.get("refreshToken");
       System.out.println("refreshToken: \t"+refreshToken);

    }
}
