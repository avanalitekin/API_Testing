package cybertek_batch8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonWithDataBind02 {
	
	@BeforeClass
	public void setUp() {
	RestAssured.baseURI="https://avanalitekin.dev.cc/";
	RestAssured.basePath="wp-json/wp/v2/";
	}
	

  
  @Test
  public void test_Create_User_Body_HashMap() throws Exception {
	  String[] roles= {"subscriber", "contributor", "author", "editor"};
	  String role=roles[new Random().nextInt(roles.length)];
	  String capabilities="capabilities."+role;
	  
		String user=new Faker().name().username();
		Map<String, String> userToBeAdded=new HashMap<String, String>();
		userToBeAdded.put("username", user);
		userToBeAdded.put("name", user);
		userToBeAdded.put("first_name", user);
		userToBeAdded.put("last_name", user);
		userToBeAdded.put("email", user+"@"+user+".com");
		userToBeAdded.put("roles", role);
		userToBeAdded.put("password", user);

		  RestAssured.given()
		  .relaxedHTTPSValidation()
		  .auth().preemptive().basic("avanalitekin", "3mersule")
		  .when()
		  .contentType(ContentType.JSON)
		  .log().all()
		  .body(userToBeAdded)
		  .post("users")
		  .then()
		  .log().all()
		  .contentType(ContentType.JSON)
		  .statusCode(201)
		  .body(capabilities, Matchers.is(true));
		  ;
		  }
  
//  @Test
  public void test_PassPOJO_ToBody() {
	  String user=new Faker().name().username();
	  String[] roles= {"subscriber", "contributor", "author", "editor"};
	  String role=roles[new Random().nextInt(roles.length)];
	  String capabilities="capabilities."+role;
	  
	  PostBody pb=new PostBody(user, user, user,  user,  user+"@"+user+".com",role, user);
	  
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .auth().preemptive().basic("admin", "admin")
	  .when()
	  .contentType(ContentType.JSON)
	  .log().all()
	  .body(pb)
	  .post("users")
	  .then()
	  .log().all()
	  .contentType(ContentType.JSON)
	  .statusCode(201)
	  .body(capabilities, Matchers.is(true));
	  ;
  }
  
  
}

class PostBody{
	
	String username;
	String name;
	String first_name;
	String last_name;
	String email;
	String roles;
	String password;
	
	public PostBody() {
		super();
	}

	public PostBody(String username, String name, String first_name, String last_name, String email, String roles,
			String password) {
		super();
		this.username = username;
		this.name = name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.roles = roles;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PostBody [username=" + username + ", name=" + name + ", first_name=" + first_name + ", last_name="
				+ last_name + ", email=" + email + ", roles=" + roles + ", password=" + password + "]";
	}
}

