package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class PathAndQueryParameters {

	
	@Test
	void testQueryandPathParams() {
		
		given()
		.pathParam("myPath", "users")  //path parameters
		.queryParam("page", 2)   //query parametrs (it will go along with requests
		.queryParam("id", 5)	//query parameters
		
		.when()
		.get("https://reqres.in/api/{myPath}")
		
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
}
