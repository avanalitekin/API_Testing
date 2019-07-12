package cybertek_batch8;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//OBJECT CLASS IS AT THE BOTTOM OF THIS CLASS
public class ResponseManipulation02 {
	
	 @BeforeClass
	  public void beforeClass() {
		  RestAssured.baseURI="https://avanalitekin.dev.cc/";
		  RestAssured.basePath="wp-json/wp/v2/";	
	  }
	 
	 @Test
	 public void test_JSONPathFirstAuthor() {
		 Response response=RestAssured.given()
				  .auth().preemptive().basic("avanalitekin", "3mersule")
				  .relaxedHTTPSValidation()
				  .when()
//				  .log().all()
				  .get("posts");
//		 System.out.println(response.asString());
		 response.prettyPrint();
		 
		 JsonPath jp=response.jsonPath();
		 List<Map<String,String>> all = jp.get("");
		 System.out.println(all.size());
		 
		 System.out.println("all authors: "+jp.get("author"));
		 System.out.println("author on the 1st post: "+jp.get("author[0]"));
		 System.out.println("all version history count: "+jp.get("_links.version-history.count"));
		 System.out.println("_links.version-history[0].count: "+jp.get("_links.version-history[0].count"));
		 System.out.println("_links.version-history.count[0]: "+jp.get("_links.version-history.count[0]"));
		 System.out.println("_links.version-history[8].count: "+jp.get("_links.version-history[8].count"));
		 System.out.println("_links.version-history.count[8]: "+jp.get("_links.version-history.count[8]"));
		 System.out.println("_links.version-history[8].count[0]: "+jp.get("_links.version-history[8].count[0]"));
		 System.out.println("_links.version-history.count[8][0]: "+jp.get("_links.version-history.count[8][0]"));
	 List<Integer> authors=jp.get("author");
//	 List<Integer> authors=jp.getList("author",Integer.class); //this will work the same as the previous line
	 System.out.println("auhtors list: "+authors);
	 List<String> versionHistoryCount=jp.get("_links.version-history.count");//result is list of arrays.
	 System.out.println("_links.version-history.count: "+versionHistoryCount);
	 
	 List<String> versionHistoryCount2=jp.get("_links.version-history.count[0]");//result is list of arrays.
	 System.out.println("_links.version-history.count[0]: "+versionHistoryCount2);
	 }
	 
//	 @Test
	 public void driverInfoTest() {
		 Response response=RestAssured.given()
				 .get("http://ergast.com/api/f1/drivers.json");
		 //get given name of all the drivers
		 JsonPath jp=response.jsonPath();
		 List<String> driversGivenNames=jp.get("MRData.DriverTable.Drivers.givenName");
		 System.out.println("driversGivenNames: "+driversGivenNames);
		 System.out.println("driversGivenNames.size(): "+driversGivenNames.size());
		 
		 
		Map<String,String> driver1Info=jp.getMap("MRData.DriverTable.Drivers[0]");
		 System.out.println("driversInfo: "+driver1Info);
		 System.out.println("driversInfoKeyset: "+driver1Info.keySet());
		 
		 Map<String,String> driver1Info2=jp.getMap("MRData.DriverTable.Drivers[0]",String.class,String.class);
		 System.out.println(driver1Info2.keySet()+"\n  ===============\n"+driver1Info2.values());
		 
		 //get all drivers info for those whose names is  George with  JsonPath
		 
		 System.out.println(jp.getString("MRData.DriverTable.Drivers[1].givenName"));
		 
		 System.out.println(jp.get("MRData.DriverTable.Drivers.findAll{it.givenName=='George'}"));
		 
		 System.out.println(jp.get("MRData.DriverTable.Drivers.findAll{it.givenName=='Kurt' && it.nationality=='German'}"));
		 System.out.println(jp.get("MRData.DriverTable.Drivers.findAll{it.givenName.length()<5}"));
		 System.out.println(jp.get("MRData.DriverTable.Drivers.findAll{it.givenName.length()<5 && it.familyName.length()>6}"));
		 System.out.println(jp.get("MRData.DriverTable.Drivers.findAll{it.givenName.length()<5}.givenName"));
		 
		 DriversInfo drObj=jp.getObject("MRData.DriverTable.Drivers[0]",DriversInfo.class);
		 System.out.println(drObj);
		 
		 System.out.println();
		 
		 DriversInfo drObj2=jp.getObject("MRData.DriverTable.Drivers[1]",DriversInfo.class);
		 System.out.println(drObj2);
		 
	 } 

}


class DriversInfo {
	String driverId;
	String url;
	String givenName;
	String familyName;
	String dateOfBirth;
	String nationality;
	
	
	public DriversInfo() {
		super();
	}


	public DriversInfo(String driverId, String url, String givenName, String familyName, String dateOfBirth,
			String nationality) {
		super();
		this.driverId = driverId;
		this.url = url;
		this.givenName = givenName;
		this.familyName = familyName;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
	}
	
	
	@Override
	public String toString() {
		return "DriversInfo [driverId=" + driverId + ", url=" + url + ", givenName=" + givenName + ", familyName="
				+ familyName + ", dateOfBirth=" + dateOfBirth + ", nationality=" + nationality + "]";
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
	 
}

