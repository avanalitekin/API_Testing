package cybertek_batch8;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPath_Got {
	/*use ths end point--GET https://api.got.show/api/characters
	 * get only the chacacters belong to house stark tips--use finAll method
	 * and get the count of it
	 * and  print out as String
	 */
	
  @Test
  public void test_Json_Path() throws Exception {
	  
	  Response response=RestAssured
			  .given()
			  .accept(ContentType.JSON)
			  .get("https://api.got.show/api/characters");
	  
	  String responseString=response.asString();
	  System.out.println("responseString: "+responseString);
	  
	  JsonPath jp=response.jsonPath();
	  
	  List<Map<String, String>>charactersAllInfo=jp.getList("findAll{it.house=='House Stark'}");
	  System.out.println("charactersAllInfo: "+charactersAllInfo);
	  
	  List<String>charactersNames=jp.getList("findAll{it.house=='House Stark'}.name", String.class);
	  System.out.println(charactersNames.size());
	  
	  String charactersMapConvertedBackToJsonStr=new ObjectMapper().writeValueAsString(charactersNames);
	  
	  System.out.println("charactersMapConvertedBackToJsonStr: "+charactersMapConvertedBackToJsonStr);
	
	  
  }
}
