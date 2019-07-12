package API_Batch10;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class PathParameterDemo {
	 @BeforeClass
	  public void setUp() {
		  RestAssured.baseURI="https://api.got.show/api";
		  
	  }
	  
	//  @Test
	  public void getCityNameTest() {
		  given()
		  .pathParam("name", "Qarth")
		  .when()
		  .get("/cities/{name}")
		  .prettyPrint();
		  
		  given()
		  .pathParam("name", "King's Landing")
		  .when()
		  .get("/cities/{name}")
		  .prettyPrint();
		  
		  given()
		  .pathParam("name", "Addam Velaryon")
		  .when()
		  .get("/characters/{name}")
		  .prettyPrint();
		  
		  given()
		  .when()
		  .get("/characters/Addam Velaryon")
		  .prettyPrint();
		  
	  }
	  
//	  @Test
	  public void getCharacterNameTest() {
		 
		  
		  given()
		  .pathParam("name", "Addam Velaryon")
		  .when()
		  .get("/characters/{name}")
		  .then()
		  .statusCode(HttpStatus.SC_OK);
		  
		  given()
		  .get("/characters/Addam Velaryon")
		  .then()
		  .statusCode(200);
		  
	  }
	  
	  @Test
	  public void getCharacterIdTest() {
		 
		  
		  given()
		  .pathParam("id", "56ffc5be0432440819385774")
		  .when()
		  .get("/characters/byId/{id}")
		  .then()
		  .statusCode(HttpStatus.SC_OK);
		  
		  given()
		  .get("/characters/byId/56ffc5be0432440819385774")
		  .then()
		  .statusCode(200);
		  
	  }
	}
