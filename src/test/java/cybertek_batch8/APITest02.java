package cybertek_batch8;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static utilities.WPUtility.create_User;

import java.util.Random;

import org.apache.http.HttpStatus;
//import io.restassured.matcher.RestAssuredMatchers;
import org.hamcrest.Matchers;

import org.testng.annotations.BeforeClass;
// https://developer.wordpress.org/rest-api/reference/users/#create-a-user 
public class APITest02 {
	String role;
	String[] roles= {"subscriber", "contributor", "author", "editor"};
	int new_UserID;
	
  
  @BeforeClass
  public void beforeClass() {
	  RestAssured.baseURI="https://avanalitekin.dev.cc/";
	  RestAssured.basePath="wp-json/wp/v2/";
	
  }
  
//@Test
public void testUserToGetUsersProfileHamCrestMatchers() {
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .when()
	  .log().all()
	  .get("users")
	  .then()
	  .log().all()
	  .statusCode(200)
	  .header("Content-Type","application/json; charset=UTF-8")
	  .body("id",Matchers.hasSize(1))
	  .body("name", Matchers.hasItem("avanalitekin"))
	  ;
	  
}
  
//  @Test
  public void testUserToGetUsersProfile() {
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .when()
	  .log().all()
	  .get("users")
	  .then()
	  .log().all()
	  .statusCode(200)
	  .header("Content-Type","application/json; charset=UTF-8")
//	  .body("id",Matchers.hasSize(1))
//	  .body("name", Matchers.hasItem("avanalitekin"))
	  ;
	  
  }
  
//  @Test
  public void testAdminToGetUsersProfileNoPreemptive() {
	  RestAssured.given()
	  .auth().basic("avanalitekin", "3mersule")
	  .relaxedHTTPSValidation()
	  .when()
	  .log().all()
	  .get("users")
	  .then()
	  .log().all()
	  .statusCode(200)
	  .header("Content-Type","application/json; charset=UTF-8")
//	  .body("id",Matchers.hasSize(1))
//	  .body("name", Matchers.hasItem("avanalitekin"))
	  ;
	  
  }
  
//  @Test
  public void testAdminToGetUsersProfileWithPreemptive() {
	  RestAssured.given()
	  .auth().preemptive().basic("avanalitekin", "3mersule")
	  .relaxedHTTPSValidation()
	  .when()
	  .log().all()
	  .get("users")
	  .then()
	  .log().all()
	  .statusCode(200)
	  .header("Content-Type","application/json; charset=UTF-8")
//	  .body("id",Matchers.hasSize(1))
//	  .body("name", Matchers.hasItem("avanalitekin"))
	  ;
	  
  }
  
//  @Test
  public void test_public_user_cannot_create_user() {
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .when()
	  .log().all()
	  .body("{"+
			  "\"username\":\"user8\",\n"+
			  "\"name\":\"user8\",\n"+
			  "\"first_name\":\"user8\",\n"+
			  "\"last_name\":\"user8\",\n"+
			  "\"email\":\"user8@user8.com\",\n"+
			  "\"roles\":\"author\",\n"+
			  "\"password\":\"user8\"\n"+
			  "}")
	  .contentType(ContentType.JSON)
	  .post("users")
	  .then()
	  .log().all()
	  .contentType(ContentType.JSON)
	  .statusCode(401)
	  .body("code", Matchers.is("rest_cannot_create_user"));
  }
  
  @Test
  public void test_admin_user_can_create_user() {
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .auth().preemptive().basic("avanalitekin", "3mersule")
	  .when()
	  .log().all()
	  .body("{"+
			  "\"username\":\"user33\",\n"+
			  "\"name\":\"user33\",\n"+
			  "\"first_name\":\"user33\",\n"+
			  "\"last_name\":\"user33\",\n"+
			  "\"email\":\"user33@user33.com\",\n"+
			  "\"roles\":\"subscriber\",\n"+
			  "\"password\":\"user33\"\n"+
			  "}")
	  .contentType(ContentType.JSON)
	  .post("users")
	  .then()
	  .log().all()
	  .contentType(ContentType.JSON)
	  .statusCode(201)
	  .body("capabilities.subscriber", Matchers.is(true));
  }
  
//  @Test
  public void test_admin_user_can_update_user() {
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .auth().preemptive().basic("avanalitekin", "3mersule")
	  .when()
	  .log().all()
	  .body("{"+
			  "\"name\":\"userthirteen\",\n"+
			  "\"first_name\":\"userthirteen\",\n"+
			  "\"last_name\":\"userthirteen\",\n"+
			  "\"email\":\"userthirteen@userthirteen.com\",\n"+
			  "\"roles\":\"subscriber\",\n"+
			  "\"password\":\"userthirteen\"\n"+
			  "}")
	  .contentType(ContentType.JSON)
	  .pathParam("id", 13)
	  .put("users/{id}")
	  .then()
	  .log().all()
	  .contentType(ContentType.JSON)
	  .statusCode(200)
	  .body("capabilities.subscriber", Matchers.is(true));
  }
  
//  @Test
  public void test_admin_user_can_delete_user() {
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .auth().preemptive().basic("avanalitekin", "3mersule")
	  .queryParam("force", true)
	  .param("reassign", 1)
	  .when()
	  .log().all()
	  .pathParam("id", 13)
	  .delete("users/{id}")
	  .then()
	  .log().all()
	  .contentType(ContentType.JSON)
	  .statusCode(200)
	  .body("deleted",Matchers.is(true))
	  ;
  }
  
//  @Test
  public void test_user_can_see_adminInfo() {
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .auth().preemptive().basic("user1", "user1")
	  .when()
	  .log().all()
	  .pathParam("id", 1)
	  .get("users/{id}")
	  .then()
	  .log().all()
	  .contentType(ContentType.JSON)
	  .statusCode(HttpStatus.SC_OK)
	  .body("name", Matchers.is("avanalitekin"))
	  ;
  }
  
//  @Test
  public void test_user_can_see_selfInfo() {
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .auth().preemptive().basic("user1", "user1")
	  .when()
	  .log().all()
	  .pathParam("id", 3)
	  .get("users/{id}")
	  .then()
	  .log().all()
	  .contentType(ContentType.JSON)
	  .statusCode(HttpStatus.SC_OK)
	  .body("name", Matchers.is("user1 user1"))
	  ;
  }
  
//  @Test
  public void test_user_cannot_see_other_users_info_other_than_admin() {
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .auth().preemptive().basic("user1", "user1")
	  .when()
	  .log().all()
	  .pathParam("id", 4)
	  .get("users/{id}")
	  .then()
	  .log().all()
	  .contentType(ContentType.JSON)
	  .statusCode(HttpStatus.SC_FORBIDDEN)
	  .body("message", Matchers.is("Sorry, you are not allowed to list users."));
	  ;
  }
  }
