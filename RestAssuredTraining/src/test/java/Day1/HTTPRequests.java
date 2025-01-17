package Day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;
//given- content type, set cookies,add auth,add param, set header info etc..
//when- get,post,put,patch,delete
//then- validate status code,extract response, extract header etc..

public class HTTPRequests {
	int id;
	@Test(priority = 1)
	void getUsers() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	@Test(priority = 2)
	void createUser() {
		HashMap data=new HashMap();
		data.put("name", "Bhargav");
		data.put("job", "Tester");
		
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		//.then()
			//.statusCode(201)
		//	.log().all();
		
	}
		@Test(priority=3, dependsOnMethods  = ("createUser"))
	void updateUser() {
		HashMap data=new HashMap();
		data.put("name", "Rohan");
		data.put("job", "Developer");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(200)
			.log().all();
			
	}@Test(priority = 4)
	void deleteUser() {
		
		given()

		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204)
		.log().all();
		
		
		
	}
	
	
}
