package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class testPostUsingJsonLib {

	//Post request body using json
		@Test(priority = 1)
		void testPostUsingJson() {
			
			JSONObject data=new JSONObject();
			
			data.put("name", "Scott");
			data.put("location", "France");
			data.put("phone", 123456);
			String coursesArr[]= {"C","C++"};
			data.put("courses", coursesArr);
			
			given()
			.contentType("application/json")
			.body(data.toString())
			
			.when()
			.post("http://localhost:3000/Students")
			
			
			.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"))
			.body("phone",equalTo(123456))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.header("Content-Type", "application/json")
			.log().all();
			
	}
		@Test(priority = 2)
		void testDelete() {
			given()
			.when()
				.delete("http://localhost:3000/Students/9603")
			.then()
				.statusCode(200);
				
		}

}
