package API_Batch10;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SerializationWithRestAssured {

	@Test
	public void testListOfObjects() {
		Response response = RestAssured.given().queryParam("amount", "9").get("https://uinames.com/api");
		List<Person> listOfPerson = response.jsonPath().getList("", Person.class);

		for (Person person : listOfPerson) {
			System.out.println(person);
		}
		System.out.println("==========================");

		for (Person person : listOfPerson) {
			System.out.println(person.getName());
			System.out.println(person.getSurname());
			System.out.println(person.getGender());
			System.out.println(person.getRegion());
			System.out.println("==========================");
		}

	}
}
