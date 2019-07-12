package API_Batch10;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Practice01 {
	/*
	 * WARM UP EXERCISE
	 * 	EX 1. get all continents from the https://api.got.show/api verify continent
	 * "Westeros" exists in resutls
	 *  EX 2. get all episodes from the https://api.got.show/api verify episode
	 * "Rains of Castamere" exists in resutls
	 *  * 
	 * Create a new class, and do both exercises in same class, different methods
	 * 
	 */
	@BeforeMethod
	public void init() {
	RestAssured.baseURI="https://api.got.show/api";	
	}
	@Test
	public void episodesTest() {
		RestAssured.basePath="/continents";
		Response response=RestAssured.get("");
		Assert.assertEquals(200, response.statusCode());
		response.prettyPrint();
		Assert.assertTrue(response.asString().contains("Westeros"));
				
	}
	
	@Test
	public void continentTest() {
		RestAssured.basePath="/episodes";
		Response response=RestAssured.get("");
		Assert.assertEquals(200, response.statusCode());
		response.prettyPrint();
		Assert.assertTrue(response.asString().contains("Rains of Castamere"));
	}
}
