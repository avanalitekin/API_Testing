package chicago.apiTests;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import chicago.apiModels.CustomResponse;
import chicago.apiModels.Student;
import io.restassured.RestAssured;
import utilities.APIUtility;

public class TestWithApiRunner {

//	@Test
	public void testWithAPIRunner1() {
		APIUtility.runGET("http://cybertekchicago.com/student/88");
		String companyLocation = APIUtility.getResponse().getCompany().getAddress().getCity();
		System.out.println("companyLocation: " + companyLocation);
		System.out.println("\n====================================================\n");
	}

//	@Test
	public void testWithAPIRunner2() {
		APIUtility.runGET("http://cybertekchicago.com/student/87");
		String companyLocation = APIUtility.getResponse().getCompany().getAddress().getCity();
		System.out.println("companyLocation: " + companyLocation);
		System.out.println("\n====================================================\n");
	}

//	@Test
	public void testWithAPIRunner3() {
		APIUtility.runGET("http://cybertekchicago.com/student/all");
		int counter=0;
		for (Student student : APIUtility.getResponse().getStudents()) {
			if (student.getBatch() == 7) {
				System.out.println(student.getFirstName());
				counter++;
			}
		}
		System.out.println("Total number of batch 7 students: "+counter);
		System.out.println("\n====================================================\n");
	}
	
//	@Test
	public void testWithAPIRunner4() {//http://cybertekchicago.com/swagger-ui.html# API Documentation Link
		String jsonStrStudent="{\r\n" + 
				"  \"batch\": 12,\r\n" + 
				"  \"company\": {\r\n" + 
				"    \"address\": {\r\n" + 
				"      \"addressId\": 0,\r\n" + 
				"      \"city\": \"string\",\r\n" + 
				"      \"state\": \"string\",\r\n" + 
				"      \"street\": \"string\",\r\n" + 
				"      \"zipCode\": 0\r\n" + 
				"    },\r\n" + 
				"    \"companyId\": 0,\r\n" + 
				"    \"companyName\": \"string\",\r\n" + 
				"    \"startDate\": \"string\",\r\n" + 
				"    \"title\": \"string\"\r\n" + 
				"  },\r\n" + 
				"  \"contact\": {\r\n" + 
				"    \"contactId\": 0,\r\n" + 
				"    \"emailAddress\": \"string\",\r\n" + 
				"    \"phone\": \"string\"\r\n" + 
				"  },\r\n" + 
				"  \"firstName\": \"FirstName13\",\r\n" + 
				"  \"id\": 0,\r\n" + 
				"  \"lastName\": \"LastName13\"\r\n" + 
				"}";
				
		APIUtility.runPOST(jsonStrStudent, "http://cybertekchicago.com/student/create");
		
		System.out.println("\n====================================================\n");
	}
	
//	@Test
	public void testStudentCreated() {
		APIUtility.runGET("http://cybertekchicago.com/student/all");
		
		for(Student student:APIUtility.getResponse().getStudents()) {
			if(student.getFirstName().equals("FirstName13")) {
				System.out.println("First Name: "+student.getFirstName()+"\nLast Name: "+student.getLastName());				
			}
		}
	}
	
//	@Test   "Failing"
	public void testStudentDelete() {
		RestAssured.given()
		.header("Accept-Language", "en-US")
		.header("Content-Type","application/json")
		.when()
		.delete("http://cybertekchicago.com/student/delete/13101")
		.then().statusCode(200);
	}

}
