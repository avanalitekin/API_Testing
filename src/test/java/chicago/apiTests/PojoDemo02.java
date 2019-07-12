package chicago.apiTests;

import chicago.apiModels.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

import io.restassured.response.Response;

public class PojoDemo02 {
	Response response;
	CustomResponse cr=new CustomResponse();

  @Test
  public void instructorList() throws Exception {
	 Response response =RestAssured
	  .get("http://cybertekchicago.com/instructor/all");
	 
	Assert.assertEquals(response.statusCode(), 200);
	
	CustomResponse cr=new ObjectMapper().readValue(response.asString(), CustomResponse.class);
	System.out.println(cr.getInstructors().get(0).getFirstName());
	
	for(Instructor instructor:cr.getInstructors()) {
		if(instructor.getSubject()==null)
			System.out.println(instructor.getFirstName()+" "+instructor.getLastName());
	}
	
  }
}

