package chicago.apiTests;

import chicago.apiModels.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;


import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoDemo01 {

//  @Test
  public void instructorTest() throws IOException {
	  String instructorJsonStr=" {\n" + 
	  		"            \"id\": 1,\n" + 
	  		"            \"firstName\": \"Jack\",\n" + 
	  		"            \"lastName\": \"Ma\",\n" + 
	  		"            \"batch\": 7,\n" + 
	  		"            \"subject\": \"Intro to Java programming\"\n" + 
	  		"        }";
	  
	  Instructor testInsOb=new ObjectMapper().readValue(instructorJsonStr, Instructor.class); 
	  System.out.println("testInsOb: "+testInsOb);
	  System.out.println("testInsOb.getSubject(): "+testInsOb.getSubject());
	  
	  String convertBacktoJson=new ObjectMapper().writeValueAsString(testInsOb);
	  System.out.println("convertBacktoJson: "+convertBacktoJson);
	  
  }
  
  @Test
  public void singleStudentTest() throws Exception {
	  Response response=RestAssured.get("http://cybertekchicago.com/student/41");
	  response.then().log().all();
	  CustomResponse crObj=new ObjectMapper().readValue(response.asString(), CustomResponse.class);
	  System.out.println("crObj: "+crObj);
	  System.out.println("crObj.getFirstName(): "+crObj.getFirstName());
	  System.out.println("crObj.getContact().getEmailAddress(): "+crObj.getContact().getEmailAddress());
  }
}


