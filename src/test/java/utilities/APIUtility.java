package utilities;

import chicago.apiModels.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.databind.ObjectMapper;

public class APIUtility {

    private static CustomResponse cr;

    public static CustomResponse getCr(){
        return cr;
    }

    public static void runGET(String uri){
        Response response = RestAssured.get(uri);
        System.out.println("STATUS: " + response.statusCode());
        System.out.println(response.asString());
        
        try {
            cr = new ObjectMapper().readValue(response.asString(), CustomResponse.class);
        } catch (IOException e) {
            System.out.println("JSON COULDN'T MAP PROPERLY");
        }
        cr.setJsonResponse(response.asString());
    }

    public static void runPOST(RequestBody body, String uri){
        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(body).when().post(uri);
        System.out.println("STATUS: " + response.statusCode());
        System.out.println(response.asString());
       
        try {
            cr = new ObjectMapper().readValue(response.asString(), CustomResponse.class);
        } catch (IOException e) {
            System.out.println("JSON COULDN'T MAP PROPERLY");
        }
    }
    
    public static void runPOST(String jsonString, String uri){
        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(jsonString).when().post(uri);
        System.out.println("STATUS: " + response.statusCode());
        System.out.println(response.asString());
       
        try {
            cr = new ObjectMapper().readValue(response.asString(), CustomResponse.class);
        } catch (IOException e) {
            System.out.println("JSON COULDN'T MAP PROPERLY");
        }
    }



    public static CustomResponse getResponse(){
        if(cr == null){
            System.out.println("Please run API first");
            throw new RuntimeException();
        }
        return cr;
    }
    
    public static String convertXMLToJson(String xmlString) {
		String jsonString=null;

        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
            jsonString = xmlJSONObj.toString();
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    return jsonString;
	}

}
