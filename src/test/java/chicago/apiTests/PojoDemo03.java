package chicago.apiTests;

import chicago.apiModels.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

import io.restassured.response.Response;

public class PojoDemo03 {

  @Test
  public void instructorList() throws Exception {
	 Response response =RestAssured
	  .get("http://cybertekchicago.com/student/all");
	 
	Assert.assertEquals(response.statusCode(), 200);
	
	CustomResponse cr=new ObjectMapper().readValue(response.asString(), CustomResponse.class);
	System.out.println(cr.getStudents().size());
	int counter=0;
	for(Student student:cr.getStudents()) {
		if(student.getCompany().getAddress().getCity().equalsIgnoreCase("chicago")){
			System.out.println(student.getFirstName());
			counter++;
		}
	}
	System.out.println("Total number of students in chicago: "+counter);
  }
}

