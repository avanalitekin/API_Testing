package cybertek_batch8;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CustomSerilizeDeserilize {
	
	 @Test
	  public void testStarWarsCharacters() throws Exception {
		 Response repsonse = RestAssured
				 .given()
				 .contentType(ContentType.JSON)
				 .get("https://api.got.show/api/characters");
//		 JsonPath jp=repsonse.jsonPath();
		 String characters_json_str=repsonse.asString();
		 StarWarsCharacters[] characters_sw_object=new ObjectMapper().readValue(characters_json_str, StarWarsCharacters[].class);
		 System.out.println(Arrays.toString(characters_sw_object));
		 System.out.println(characters_sw_object.length);
		 
		 String converted_characters_sw_object_back_to_JsonStr=new ObjectMapper().writeValueAsString(characters_sw_object);
		 System.out.println("converted_characters_sw_object_back_to_JsonStr: "+converted_characters_sw_object_back_to_JsonStr);  
		 //Serialized characters' list is below
		 List<StarWarsCharacters> converted_characters_json_strArray_toArrayList=JsonPath.from(characters_json_str).getList("",StarWarsCharacters.class);
		 System.out.println("converted_characters_json_strArray_toArrayList: "+converted_characters_json_strArray_toArrayList);
		 System.out.println("converted_characters_json_strArray_toArrayList Size: "+converted_characters_json_strArray_toArrayList.size());
		 
		 //nonserialized string as it is not  obtained from characters_sw_object
		 String name_of_the_first_character=JsonPath.from(characters_json_str).getString("name[0]");
		 System.out.println("name_of_the_first_character: "+name_of_the_first_character);
		//nonserialeze character list as it is not  obtained from characters_sw_object. It is directly obtained from the json string array.
		 List<StarWarsCharacters> charactersList=JsonPath.from(characters_json_str).getList("");
		 System.out.println("charactersList: "+charactersList);
		 System.out.println("charactersList size: "+charactersList.size());
	 
	 }
	
}

@JsonIgnoreProperties(ignoreUnknown=true)
class StarWarsCharacters{
	String _id;
	boolean male;
	String house;
	String slug;
	String name;
	int __v;
	double pageRank;
	String[] books;
	String updatedAt;
	String createdAt;
	String[] titles;
	public StarWarsCharacters() {
		super();
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int get__v() {
		return __v;
	}
	public void set__v(int __v) {
		this.__v = __v;
	}
	public double getPageRank() {
		return pageRank;
	}
	public void setPageRank(double pageRank) {
		this.pageRank = pageRank;
	}
	public String[] getBooks() {
		return books;
	}
	public void setBooks(String[] books) {
		this.books = books;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String[] getTitles() {
		return titles;
	}
	public void setTitles(String[] titles) {
		this.titles = titles;
	}
	@Override
	public String toString() {
		return "StarWarsCharacters [_id=" + _id + ", male=" + male + ", house=" + house + ", slug=" + slug + ", name="
				+ name + ", __v=" + __v + ", pageRank=" + pageRank + ", books=" + Arrays.toString(books)
				+ ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + ", titles=" + Arrays.toString(titles) + "]";
	}
	
	
}

