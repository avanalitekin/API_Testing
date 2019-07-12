package cybertek_batch8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;

public class SimplePojoDemo {
	ObjectMapper om;
	
//	@Test
	public void userNamePasswordTest() throws IOException {
		 String jsonString="{ \"username\": \"user1234\", \"password\": \"Password\" }";
		 Login login=new ObjectMapper().readValue(jsonString, Login.class);
		 String username=login.getUsername();
		 String password=login.getPassword();
		 System.out.println(username);
		 System.out.println(password);
		 
				 
	}
	
//  @Test
  public void databindTest() throws Exception {
	  String jsonString= "{\"name\":\"Ali\",\"age\":45}";
	  
	  Person person=new ObjectMapper().readValue(jsonString, Person.class);
	  System.out.println("jsonString: "+jsonString);
	  System.out.println("dataBindObj: "+person);
	  System.out.println(person.getName());
	  System.out.println(person.getAge());
	  
	  String convertedToSTring=new ObjectMapper().writeValueAsString(person);
	  System.out.println("convertedToSTring: "+convertedToSTring);
//	  
//	  String jstring="{\n" + 
//	  		"	\"driverId\": \"abate\",\n" + 
//	  		"	\"url\": \"http://en.wikipedia.org/wiki/Carlo_Mario_Abate\",\n" + 
//	  		"	\"givenName\": \"Carlo\",\n" + 
//	  		"	\"familyName\": \"Abate\",\n" + 
//	  		"	\"dateOfBirth\": \"1932-07-10\",\n" + 
//	  		"	\"nationality\": \"Italian\"\n" + 
//	  		"}";
//	  
//	  System.out.println(jstring);
//	  
//	  TestDriverInfo driverObj=new ObjectMapper().readValue(jstring, TestDriverInfo.class);
//	  System.out.println("driverObj: "+driverObj);
//	  
//	  String testDriverOjbConvertedBackToString=new ObjectMapper().writeValueAsString(driverObj);
//	  
//	  System.out.println("testDriverOjbConvertedBackToString: "+testDriverOjbConvertedBackToString);
	  
  }
  
  @Test
  public void databindTestArray() throws Exception {
	  String driversArrayJsonStr= DriversArray.driversArray;
	  System.out.println("driversArrayStr: "+driversArrayJsonStr);
	  
	  TestDriverInfo[] driversArrObj=new ObjectMapper().readValue(driversArrayJsonStr, TestDriverInfo[].class);
	  System.out.println("driversArrObj: "+Arrays.toString(driversArrObj));
	  System.out.println(driversArrObj[0].getGivenName());
	  System.out.println(driversArrObj[0].getFamilyName());
	  System.out.println(driversArrObj[0].getDriverId());
	  System.out.println(driversArrObj[0].getDateOfBirth());
	  System.out.println(driversArrObj[0].getNationality());
	  System.out.println(driversArrObj[0].getUrl());
	  System.out.println();
	  System.out.println(driversArrObj[1].getGivenName());
	  System.out.println(driversArrObj[1].getFamilyName());
	  System.out.println(driversArrObj[1].getDriverId());
	  System.out.println(driversArrObj[1].getDateOfBirth());
	  System.out.println(driversArrObj[1].getNationality());
	  System.out.println(driversArrObj[1].getUrl());
	  
	  
	  String driversArrObjConvertedBackToJsonStr=new ObjectMapper().writeValueAsString(driversArrObj);
	  
	  System.out.println("driversArrObjConvertedBackToJsonStr: "+driversArrObjConvertedBackToJsonStr);
	  
	  List<TestDriverInfo> driversArrObjList=Arrays.asList(driversArrObj);
	  System.out.println("driversArrObjList: "+driversArrObjList);
//	  Another way  of the above is below
	  List<TestDriverInfo> driversArrObjList2=JsonPath.from(driversArrayJsonStr).get("");
	  System.out.println("driversArrObjList2: "+driversArrObjList2);
	  
	 
	  
  }
}

class Person {
	String name;
	int age;
	
	
	public Person() {
		super();
	}


	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	@Override
	public String toString() {
		return "TestJsonDataBind [name=" + name + ", age=" + age + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
		
		
	}
	
class TestDriverInfo{
	String driverId;
	String url;
	String givenName;
	String familyName;
	String dateOfBirth;
	String nationality;
	List<TestDriverInfo> drivers;
	
	
	public List<TestDriverInfo> getDrivers() {
		return drivers;
	}


	public void setDrivers(List<TestDriverInfo> drivers) {
		this.drivers = drivers;
	}


	public TestDriverInfo() {
		super();
	}


	public TestDriverInfo(String driverId, String url, String givenName, String familyName, String dateOfBirth,
			String nationality) {
		super();
		this.driverId = driverId;
		this.url = url;
		this.givenName = givenName;
		this.familyName = familyName;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
	}


	public String getDriverId() {
		return driverId;
	}


	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getGivenName() {
		return givenName;
	}


	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}


	public String getFamilyName() {
		return familyName;
	}


	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	@Override
	public String toString() {
		return "driverId=" + driverId + ", url=" + url + ", givenName=" + givenName
				+ ", familyName=" + familyName + ", dateOfBirth=" + dateOfBirth + ", nationality=" + nationality
				;
	}
}
class DriversArray{
	static String driversArray="[\n" + 
			"                {\n" + 
			"                    \"driverId\": \"abate\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Carlo_Mario_Abate\",\n" + 
			"                    \"givenName\": \"Carlo\",\n" + 
			"                    \"familyName\": \"Abate\",\n" + 
			"                    \"dateOfBirth\": \"1932-07-10\",\n" + 
			"                    \"nationality\": \"Italian\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"abecassis\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/George_Abecassis\",\n" + 
			"                    \"givenName\": \"George\",\n" + 
			"                    \"familyName\": \"Abecassis\",\n" + 
			"                    \"dateOfBirth\": \"1913-03-21\",\n" + 
			"                    \"nationality\": \"British\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"acheson\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Kenny_Acheson\",\n" + 
			"                    \"givenName\": \"Kenny\",\n" + 
			"                    \"familyName\": \"Acheson\",\n" + 
			"                    \"dateOfBirth\": \"1957-11-27\",\n" + 
			"                    \"nationality\": \"British\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"adams\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Philippe_Adams\",\n" + 
			"                    \"givenName\": \"Philippe\",\n" + 
			"                    \"familyName\": \"Adams\",\n" + 
			"                    \"dateOfBirth\": \"1969-11-19\",\n" + 
			"                    \"nationality\": \"Belgian\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"ader\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Walt_Ader\",\n" + 
			"                    \"givenName\": \"Walt\",\n" + 
			"                    \"familyName\": \"Ader\",\n" + 
			"                    \"dateOfBirth\": \"1913-12-15\",\n" + 
			"                    \"nationality\": \"American\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"adolff\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Kurt_Adolff\",\n" + 
			"                    \"givenName\": \"Kurt\",\n" + 
			"                    \"familyName\": \"Adolff\",\n" + 
			"                    \"dateOfBirth\": \"1921-11-05\",\n" + 
			"                    \"nationality\": \"German\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"agabashian\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Fred_Agabashian\",\n" + 
			"                    \"givenName\": \"Fred\",\n" + 
			"                    \"familyName\": \"Agabashian\",\n" + 
			"                    \"dateOfBirth\": \"1913-08-21\",\n" + 
			"                    \"nationality\": \"American\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"ahrens\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Kurt_Ahrens,_Jr.\",\n" + 
			"                    \"givenName\": \"Kurt\",\n" + 
			"                    \"familyName\": \"Ahrens\",\n" + 
			"                    \"dateOfBirth\": \"1940-04-19\",\n" + 
			"                    \"nationality\": \"German\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"albers\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Christijan_Albers\",\n" + 
			"                    \"givenName\": \"Christijan\",\n" + 
			"                    \"familyName\": \"Albers\",\n" + 
			"                    \"dateOfBirth\": \"1979-04-16\",\n" + 
			"                    \"nationality\": \"Dutch\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"albon\",\n" + 
			"                    \"url\": \"https://en.wikipedia.org/wiki/Alexander_Albon\",\n" + 
			"                    \"givenName\": \"Alexander\",\n" + 
			"                    \"familyName\": \"Albon\",\n" + 
			"                    \"dateOfBirth\": \"1996-03-23\",\n" + 
			"                    \"nationality\": \"Thai\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"alboreto\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Michele_Alboreto\",\n" + 
			"                    \"givenName\": \"Michele\",\n" + 
			"                    \"familyName\": \"Alboreto\",\n" + 
			"                    \"dateOfBirth\": \"1956-12-23\",\n" + 
			"                    \"nationality\": \"Italian\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"alesi\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Jean_Alesi\",\n" + 
			"                    \"givenName\": \"Jean\",\n" + 
			"                    \"familyName\": \"Alesi\",\n" + 
			"                    \"dateOfBirth\": \"1964-06-11\",\n" + 
			"                    \"nationality\": \"French\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"alguersuari\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Jaime_Alguersuari\",\n" + 
			"                    \"givenName\": \"Jaime\",\n" + 
			"                    \"familyName\": \"Alguersuari\",\n" + 
			"                    \"dateOfBirth\": \"1990-03-23\",\n" + 
			"                    \"nationality\": \"Spanish\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"alliot\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Philippe_Alliot\",\n" + 
			"                    \"givenName\": \"Philippe\",\n" + 
			"                    \"familyName\": \"Alliot\",\n" + 
			"                    \"dateOfBirth\": \"1954-07-27\",\n" + 
			"                    \"nationality\": \"French\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"allison\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Cliff_Allison\",\n" + 
			"                    \"givenName\": \"Cliff\",\n" + 
			"                    \"familyName\": \"Allison\",\n" + 
			"                    \"dateOfBirth\": \"1932-02-08\",\n" + 
			"                    \"nationality\": \"British\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"alonso\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Fernando_Alonso\",\n" + 
			"                    \"givenName\": \"Fernando\",\n" + 
			"                    \"familyName\": \"Alonso\",\n" + 
			"                    \"dateOfBirth\": \"1981-07-29\",\n" + 
			"                    \"nationality\": \"Spanish\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"amati\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Giovanna_Amati\",\n" + 
			"                    \"givenName\": \"Giovanna\",\n" + 
			"                    \"familyName\": \"Amati\",\n" + 
			"                    \"dateOfBirth\": \"1959-07-20\",\n" + 
			"                    \"nationality\": \"Italian\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"amick\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Red_Amick\",\n" + 
			"                    \"givenName\": \"Red\",\n" + 
			"                    \"familyName\": \"Amick\",\n" + 
			"                    \"dateOfBirth\": \"1929-01-19\",\n" + 
			"                    \"nationality\": \"American\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"george_amick\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/George_Amick\",\n" + 
			"                    \"givenName\": \"George\",\n" + 
			"                    \"familyName\": \"Amick\",\n" + 
			"                    \"dateOfBirth\": \"1924-10-24\",\n" + 
			"                    \"nationality\": \"American\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"amon\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Chris_Amon\",\n" + 
			"                    \"givenName\": \"Chris\",\n" + 
			"                    \"familyName\": \"Amon\",\n" + 
			"                    \"dateOfBirth\": \"1943-07-20\",\n" + 
			"                    \"nationality\": \"New Zealander\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"anderson\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Bob_Anderson_(racing_driver)\",\n" + 
			"                    \"givenName\": \"Bob\",\n" + 
			"                    \"familyName\": \"Anderson\",\n" + 
			"                    \"dateOfBirth\": \"1931-05-19\",\n" + 
			"                    \"nationality\": \"British\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"andersson\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Conny_Andersson_(racing_driver)\",\n" + 
			"                    \"givenName\": \"Conny\",\n" + 
			"                    \"familyName\": \"Andersson\",\n" + 
			"                    \"dateOfBirth\": \"1939-12-28\",\n" + 
			"                    \"nationality\": \"Swedish\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"andretti\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Michael_Andretti\",\n" + 
			"                    \"givenName\": \"Michael\",\n" + 
			"                    \"familyName\": \"Andretti\",\n" + 
			"                    \"dateOfBirth\": \"1962-10-05\",\n" + 
			"                    \"nationality\": \"American\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"mario_andretti\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Mario_Andretti\",\n" + 
			"                    \"givenName\": \"Mario\",\n" + 
			"                    \"familyName\": \"Andretti\",\n" + 
			"                    \"dateOfBirth\": \"1940-02-28\",\n" + 
			"                    \"nationality\": \"American\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"andrews\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Keith_Andrews_(driver)\",\n" + 
			"                    \"givenName\": \"Keith\",\n" + 
			"                    \"familyName\": \"Andrews\",\n" + 
			"                    \"dateOfBirth\": \"1920-06-15\",\n" + 
			"                    \"nationality\": \"American\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"apicella\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Marco_Apicella\",\n" + 
			"                    \"givenName\": \"Marco\",\n" + 
			"                    \"familyName\": \"Apicella\",\n" + 
			"                    \"dateOfBirth\": \"1965-10-07\",\n" + 
			"                    \"nationality\": \"Italian\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"armi\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Frank_Armi\",\n" + 
			"                    \"givenName\": \"Frank\",\n" + 
			"                    \"familyName\": \"Armi\",\n" + 
			"                    \"dateOfBirth\": \"1918-10-12\",\n" + 
			"                    \"nationality\": \"American\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"arnold\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Chuck_Arnold\",\n" + 
			"                    \"givenName\": \"Chuck\",\n" + 
			"                    \"familyName\": \"Arnold\",\n" + 
			"                    \"dateOfBirth\": \"1926-05-30\",\n" + 
			"                    \"nationality\": \"American\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"arnoux\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Ren%C3%A9_Arnoux\",\n" + 
			"                    \"givenName\": \"René\",\n" + 
			"                    \"familyName\": \"Arnoux\",\n" + 
			"                    \"dateOfBirth\": \"1948-07-04\",\n" + 
			"                    \"nationality\": \"French\"\n" + 
			"                },\n" + 
			"                {\n" + 
			"                    \"driverId\": \"arundell\",\n" + 
			"                    \"url\": \"http://en.wikipedia.org/wiki/Peter_Arundell\",\n" + 
			"                    \"givenName\": \"Peter\",\n" + 
			"                    \"familyName\": \"Arundell\",\n" + 
			"                    \"dateOfBirth\": \"1933-11-08\",\n" + 
			"                    \"nationality\": \"British\"\n" + 
			"                }\n" + 
			"            ]";
}
class Login{
	String username;
	String password;
	public Login() {};
	
	public Login(String username, String password) {
		this.username=username;
		this.password=password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}