package com.api_testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetData {
  @Test
  public void testResponsecode1() {
//	  without importing static mehtods === import io.restassured.RestAssured;
	  Response response=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
//	  with importing static methods === import static io.restassured.RestAssured.*;
//	  Response response=get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	  int code=response.getStatusCode();
	  System.out.println("Status code is: "+code);
	  Assert.assertEquals(code,200);
	  
	  String data=response.asString();
	  System.out.println("Data is: "+data);
	  
	  System.out.println("Response time: "+response.time());
	  System.out.println("Response get time: "+response.getTime());
  }
  
  @Test
  public void testResponsecode2() {
//	  without importing static mehtods === import io.restassured.RestAssured;
//	  Response response=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
//	  with importing static methods === import static io.restassured.RestAssured.*;
	  String url="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
//	  Response response=get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	  int code=get(url).getStatusCode();
	  System.out.println("Status code is: "+code);
	  Assert.assertEquals(code,200);
	  
	  String data=get("url").asString();
	  System.out.println("Data is: "+data);
	  
	  System.out.println("Response time: "+get(url).time());
	  System.out.println("Response get time: "+get(url).getTime());
  }
}
