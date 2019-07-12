package API_Batch10;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import utilities.BookItDBUtility;
import utilities.BookItDBUtility2;
import utilities.BookItUtility;

public class PostStudentTest {
	
	String token = BookItUtility.getTeacherToken();
	String firstName = new Faker().name().firstName();
	String lastName = new Faker().name().lastName();
	String email = new Faker().internet().emailAddress();
	String password = new Faker().internet().password();
	String role = "student-team-member";
	String campusLocation = "IL";
	Integer batchNumber = 8;
	String teamName = "Cucumber";

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";
	}

	@Test (priority=0)
	public void postStudent() {
		String expectedMessage = "user " + firstName + " " + lastName + " has been added to database.";

		RestAssured.given().log().all().header("Authorization", token).queryParam("first-name", firstName)
				.queryParam("last-name", lastName).queryParam("email", email).queryParam("password", password)
				.queryParam("role", role).queryParam("campus-location", campusLocation)
				.queryParam("batch-number", batchNumber).queryParam("team-name", teamName).post("/api/students/student")
				.then().log().all().statusCode(201).body(Matchers.is(expectedMessage));

	}
	
	@Test (priority=1)
	public void verifyStudent() {
		String query="select ut.email, ut.firstname, ut.lastname, ut.role, ut.batch_number, c.location, ut.team_name from (select email, firstname, lastname, role, batch_number, u.campus_id, u.team_id, t.name team_name from users u join team t on u.team_id=t.id) ut join campus c on c.id=ut.campus_id where ut.email='"+email+"';";
		System.out.println(query);
		BookItDBUtility2.getConnection();
		BookItDBUtility2.executeQuery(query);
		List<List<Object>> studentInfo= BookItDBUtility2.getRowList();
		Assert.assertTrue(studentInfo.get(0).contains(firstName));
		Assert.assertTrue(studentInfo.get(0).contains(lastName));
		Assert.assertTrue(studentInfo.get(0).contains(email));
		Assert.assertTrue(studentInfo.get(0).contains(role));
		Assert.assertTrue(studentInfo.get(0).contains(campusLocation));
		Assert.assertTrue(studentInfo.get(0).contains(batchNumber));
		Assert.assertTrue(studentInfo.get(0).contains(teamName));
	}
}
