package API_Batch10;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.BookItUtility;

public class JsonPathExamples {
	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";
	}
  @Test
  public void test() {
	  
	  String token =BookItUtility.getTeacherToken();
	  System.out.println("token: "+token);
	  
	  Response response=RestAssured.given()
			  .header("Authorization",token)
			  .get("/api/clusters");
	  JsonPath jp=response.jsonPath();
	 String id=jp.getString("id");
	 System.out.println(id);
	 
	 List<String> ids=jp.get("id");//this one is the same as  List<String> idsList=jp.getList("id");
	 System.out.println(ids);
	 
	 List<String> idsList=jp.getList("id");
	 System.out.println(idsList);
	 
	 Integer firstId=jp.get("id[0]");
	 System.out.println(firstId);
	 
	 String idFirst=jp.getString("id[0]");
	 System.out.println(idFirst);
	 
	 String harvardRoom=jp.getString("rooms[0].name[0]");
	 System.out.println(harvardRoom);
	 
	 List<String> rooms=jp.get("rooms[0].name");
	 System.out.println(rooms);
	 
	 List<String> roomsAll=jp.get("rooms.name");
	 System.out.println(roomsAll);
	 
	 Map<String,Object> cluster1=jp.getMap("rooms[0][0]");
	 for(Object str:cluster1.values()) {
		 System.out.println(str);
	 }
	 
	 Map<String,String> cluster1String=jp.getMap("rooms[0][0]",String.class,String.class);
	 for(String str:cluster1String.values()) {
		 System.out.println(str);
	 }
	 
	 List<Map<String,String>> clustersList=jp.getList("rooms");
	 for(int i=0; i<clustersList.size();i++) {
		 System.out.println(clustersList.get(i));
	 }
	 	 
	  
	   }
}
