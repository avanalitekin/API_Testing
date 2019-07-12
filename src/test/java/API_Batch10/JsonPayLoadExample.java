package API_Batch10;


import java.util.Random;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonPayLoadExample {
  @Test
  public void payloadTest() throws Exception {
	  RestAssured.baseURI="http://cybertekchicago.com";
	  String firstName=new Faker().name().firstName();
	  String lastName=new Faker().name().lastName();
	  int batch=new Random().nextInt(20)+1;
	  String subject=new Faker().educator().course();
	  Instructor instructor=new Instructor();
	  instructor.setFirstName(firstName);
	  instructor.setLastName(lastName);
	  instructor.setBatch(batch);
	  instructor.setSubject(subject);
	  
	  Response postResponse=RestAssured.given().contentType(ContentType.JSON).body(instructor).when().post("/instructor/create");
	 postResponse.then().log().all();
	 
	 int id=postResponse.path("id");
	 Response getResponse=RestAssured.given().pathParam("id", id).when().get("/instructor/{id}");
	 getResponse.then().log().all().statusCode(200);
	 
	 Instructor instructor2=new ObjectMapper().readValue(getResponse.asString(), Instructor.class);
	 System.out.println("instructor First name: "+instructor2.getFirstName());
	 System.out.println("instructor First name: "+instructor2.getLastName());
	 System.out.println("instructor First name: "+instructor2.getBatch());
	 System.out.println("instructor First name: "+instructor2.getId());
	 System.out.println("instructor First name: "+instructor2.getSubject());
	 
	 MatcherAssert.assertThat(instructor2.getFirstName(),Matchers.is(instructor.getFirstName()));
	 MatcherAssert.assertThat(instructor2.getLastName(),Matchers.is(instructor.getLastName()));
	 MatcherAssert.assertThat(instructor2.getBatch(),Matchers.is(instructor.getBatch()));
	 MatcherAssert.assertThat(instructor2.getSubject(),Matchers.is(instructor.getSubject()));	  
  }
}
