package API_Batch10;


import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PojoExample {

	@Test (priority=0)
	public void testGSon01() {

		System.out.println(
				"\n================EXAMPLE 1: SERIALIZATION AND DESERIALIZATION WITH Gson below ====================\n");
		Person person = new Person();
		person.setName("Ali");
		person.setSurname("Tekin");
		person.setGender("male");
		person.setRegion("Earth");

		System.out.println("person object: " + person);

		String jsonString = new Gson().toJson(person);

		System.out.println("jsonString from person object: " + jsonString);

		Person backToPerson = new Gson().fromJson(jsonString, Person.class);
		System.out.println("backToPerson: " + backToPerson);

	}

	@Test (priority=1)
	public void testGSon02() {

		System.out.println(
				"\n================EXAMPLE 2: SERIALIZATION AND DESERIALIZATION WITH Gson below ====================\n");
		String jsonString = "{\"name\":\"Ali\",\"surname\":\"Tekin\",\"gender\":\"male\",\"region\":\"Earth\"}";
		System.out.println("jsonStringFirst: " + jsonString);
		Person person2 = new Gson().fromJson(jsonString, Person.class);
		System.out.println("person2: " + person2);

		String jsonStringFromPerson2 = new Gson().toJson(person2);

		System.out.println("jsonStringFromPerson2: " + jsonStringFromPerson2);

	}

	@Test (priority=2)
	public void testObjectMapper01() throws Exception {

		System.out.println(
				"\n================EXAMPLE 1: SERIALIZATION AND DESERIALIZATION WITH OBJECT MAPPER BELOW ====================\n");
		Person personForOM = new Person();
		personForOM.setName("Dilo");
		personForOM.setSurname("Sulo");
		personForOM.setGender("male");
		personForOM.setRegion("Texas");

		System.out.println("personForOM: " + personForOM);

		String jsonStringWithOM = new ObjectMapper().writeValueAsString(personForOM);
		System.out.println("jsonStringWithOM: " + jsonStringWithOM);

		Person personFromJsonwihtOM = new ObjectMapper().readValue(jsonStringWithOM, Person.class);
		System.out.println("personFromJsonwihtOM: " + personFromJsonwihtOM);

	}

	@Test (priority=3)
	public void testObjectMapper02() throws Exception {

		System.out.println(
				"\n================EXAMPLE 2: SERIALIZATION AND DESERIALIZATION WITH OBJECT MAPPER BELOW ====================\n");
		String jsonStringforOM = "{\"name\":\"Dilo\",\"surname\":\"Sulo\",\"gender\":\"male\",\"region\":\"Texas\"}";
		System.out.println("jsonStringforOM: " + jsonStringforOM);
		Person personFromJsonStringforOM = new ObjectMapper().readValue(jsonStringforOM, Person.class);
		System.out.println("personFromJsonStringforOM: " + personFromJsonStringforOM);
		String jsonStringFromPersonwithOM = new ObjectMapper().writeValueAsString(personFromJsonStringforOM);
		System.out.println("personFromJsonStringforOM: " + jsonStringFromPersonwithOM);

	}
	
	@Test (priority=4)
	public void testGsonAndObjectMapper() throws Exception {
		System.out.println(
				"\n================EXAMPLE: SERIALIZATION AND DESERIALIZATION WITH OBJECT MAPPER and Gson BELOW ====================\n");
		Person person=new Person();
		person.setName("Mark");
		person.setSurname("Tower");
		
		String jsonStringWithGson=new Gson().toJson(person);
		String jsonStringWithOM=new ObjectMapper().writeValueAsString(person);
		
		System.out.println("jsonStringWithGson: "+jsonStringWithGson);
		System.out.println("jsonStringWithOM: "+jsonStringWithOM);
		
	}
	
	@Test (priority=5)
	public void testFromAPI() throws Exception {
		
		System.out.println(
				"\n================EXAMPLE: SERIALIZATION AND DESERIALIZATION FROM RESTASSURED RESPONSE ====================\n");
		Response response=RestAssured.given().get("https://uinames.com/api");
		
		Person person=response.as(Person.class);
		System.out.println("personFromResponse: "+person);
		System.out.println("Name: "+person.getName());
		System.out.println("Last name: "+person.getSurname());
		System.out.println("Gender: "+person.getGender());
		System.out.println("Region: "+person.getRegion());
		
		System.out.println("\n================EXAMPLE: SERIALIZATION WITH Gson ====================\n");
		
		Person person2=new Gson().fromJson(response.asString(), Person.class);
		System.out.println("person2: "+person2);
		System.out.println("person2 name: "+person2.getName());
		System.out.println("person2 lastname: "+person2.getSurname());
		System.out.println("person2 Gender: "+person2.getGender());
		System.out.println("person2 Region: "+person2.getRegion());
		
		System.out.println("\n================EXAMPLE: SERIALIZATION WITH OBJECT MAPPER ====================\n");
		Person person3=new ObjectMapper().readValue(response.asString(), Person.class);
		System.out.println("person3: "+person3);
		System.out.println("person3 name: "+person3.getName());
		System.out.println("person3 lastname: "+person3.getSurname());
		System.out.println("person3 Gender: "+person3.getGender());
		System.out.println("person3 Region: "+person3.getRegion());
	}
}
