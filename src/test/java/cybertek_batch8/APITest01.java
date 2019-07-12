package cybertek_batch8;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class APITest01 {

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "https://avanalitekin.dev.cc/wp-json";
		RestAssured.basePath = "/wp/v2";

	}

  @Test
	public void test1() {

		given()
		.relaxedHTTPSValidation()
//		.when()
		.get("https://avanalitekin.dev.cc/wp-json/wp/v2/posts/17").then()
//		.log().all()
				.statusCode(200)
//				.contentType("application/json")
				;

	}

//  @Test
	public void test2() {

		given().relaxedHTTPSValidation().when().log().all()
//		 .get("https://avanalitekin.dev.cc/wp-json/wp/v2/posts/9")
				.get("https://avanalitekin.dev.cc/wp-json/wp/v2/posts/{id}", 9).then().statusCode(200).and()
				.body("id", equalTo(9)).and().body("title.rendered", equalTo("THIS TITLE UPDATED ON POSTMAN")).and()
				.body("status", equalTo("publish"));
	}

//  @Test
	public void test3() {

		given().relaxedHTTPSValidation().when().log().all().get("/posts/9")// using baseURI
				.then().statusCode(200).and().body("id", equalTo(9)).and()
				.body("title.rendered", equalTo("THIS TITLE UPDATED ON POSTMAN")).and()
				.body("status", equalTo("publish"));
	}

//  @Test
	public void testWithHamcrest() {
		int a = 5, b = 5;
		int c = 6;
		Assert.assertTrue(a == b);
		Assert.assertEquals(a, b);
		assertThat(a, equalTo(b));
		assertThat(c, greaterThan(a));
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		assertThat(list, hasSize(4));
		assertThat(list, everyItem(greaterThan(0)));
	}

  @Test
	public void test4() {
		given().relaxedHTTPSValidation().when().log().all().queryParam("per_page", 1).get("/posts").then().log()
				.ifValidationFails().assertThat().statusCode(200).and().body("id", hasItem(30))
				.body("title.rendered", hasItem("THIS POST COMES AFTER POST 27"));

	}

//  @Test
	public void prettyPrintBody() {
		given().relaxedHTTPSValidation().when().log().all().get("/posts").body().prettyPrint();
	}

//  @Test
	public void simplePostTest() {
		given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule")
				.contentType(ContentType.JSON).when()
				.body("{\n" + "  \"title\":\"This post is created on Eclipse to have more post\",\n"
						+ "  \"content\": \"This post is created on Eclipse to have more most to test\",\n" + "  \"status\" : \"publish\"\n"
						+ "}")
				.log().all().post("/posts").then().log().all().statusCode(201);

	}

//  @Test 
	public void simplePutTest() {
		given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule")
				.contentType(ContentType.JSON).when()
				.body("{\n" + "  \"title\":\"This is an update to the post created on Eclipse previously!\" " + "}")
				.log().all().put("/posts/20").then().log().all().statusCode(200)
				.body("title.raw", is("This is an update to the post created on Eclipse previously!"));

	}

//	@Test
	public void simplePermanentDeleteTest() {
		given()
		.relaxedHTTPSValidation()
		.auth().preemptive().basic("avanalitekin", "3mersule")
		.when()
		.pathParam("deleteID", 21)
		.queryParam("force", true)
		.delete("/posts/{deleteID}")
		.then()
		.statusCode(200)
		.body("deleted", is(true));

	}

//	@Test
	public void simpleMoveToTrashDeleteTest() {
		given()
		.relaxedHTTPSValidation()
		.auth().preemptive().basic("avanalitekin", "3mersule")
		.when()
		.pathParam("deleteID", 20)
		.delete("/posts/{deleteID}")
		.then()
		.statusCode(200)
		.body("deleted", is(true));

	}

}
