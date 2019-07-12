package cybertek_batch8;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static utilities.WPUtility.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.apache.http.HttpStatus;
//import io.restassured.matcher.RestAssuredMatchers;
import org.hamcrest.Matchers;

import org.testng.annotations.BeforeClass;
//https://jsoneditoronline.org/
public class APITest03 {
	String roleCreate;
	String roleUpdate;
	String[] roles= {"subscriber", "contributor", "author", "editor"};
	int new_UserID;
	
  
  @BeforeClass
  public void beforeClass() {
	  RestAssured.baseURI="https://avanalitekin.dev.cc/";
	  RestAssured.basePath="wp-json/wp/v2/";
	  roleCreate=roles[new Random().nextInt(roles.length)];
	  roleUpdate=roles[new Random().nextInt(roles.length)];
	
  }
  

//  @Test (priority=0)
  public void create_User() {
	  new_UserID=utilities.WPUtility.create_User(roleCreate);
  }
//  @Test (priority=1)
  public void update_User() {
	  utilities.WPUtility.update_User(roleUpdate, new_UserID); 
  }
//  @Test (priority=2)
  public void delete_User() {
	  utilities.WPUtility.delete_User(new_UserID); 
  }
  
//  @Test
  public void instructorAll(){
      Response response = RestAssured.get("http://cybertekchicago.com/instructor/all");
      response.then().log().body();
//    System.out.println(response.asString());
    JsonPath jp = response.jsonPath();
    System.out.println(jp.get("instructors.id"));
    List<Integer> batchList=new ArrayList<Integer>();
    batchList=jp.get("instructors.batch");
//    Collections.sort(batchList);
    System.out.println(batchList);
    Set<Integer> batchSet=new TreeSet<Integer>(batchList);
    System.out.println(batchSet);
    List<String> subjectsList = jp.get("instructors.subject");
    System.out.println(subjectsList.size());
//    List<Map<String,String>> instructors = jp.get("instructors");
//    System.out.println(instructors.size());
//    List<String> subjects=new ArrayList<String>();
//    for (Map<String,String> element:instructors) {
//  	  subjects.add(element.get("subject"));
//    }
//    System.out.println(subjects.size());
 } 
  
//  @Test
  public void instructorOne(){
      Response response = RestAssured.get("http://cybertekchicago.com/instructor/61");
      response.then().log().body();
//      System.out.println(response.asString());
      JsonPath jp = response.jsonPath();
      System.out.println("id: "+jp.get("id"));
      System.out.println("first name: "+jp.get("firstName"));
      System.out.println("last name: "+jp.get("lastName"));
      System.out.println("batch number: "+jp.get("batch"));
      System.out.println("subject: "+jp.get("subject"));
   }   
  @Test
  public void driverInfo() {
	  Response response=RestAssured.get("http://ergast.com/api/f1/drivers.json");
	  response.then().log().all();
	  JsonPath jp=response.jsonPath();
	  List<String> driversInfo=jp.get("MRData.DriverTable.Drivers");
	  System.out.println(driversInfo);
//	  String str=jp.getString(path)
  }
  }
  
  

