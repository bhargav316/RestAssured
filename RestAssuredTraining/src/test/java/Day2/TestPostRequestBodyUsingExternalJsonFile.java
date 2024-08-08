package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class TestPostRequestBodyUsingExternalJsonFile {
	@Test(priority = 1)
	void testPostUsingExternalJsonFile() throws FileNotFoundException {
		
		File file=new File(".\\body.json");
		java.io.FileReader fr=new java.io.FileReader(file);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/Students")
		
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("location",equalTo("France"))
		.body("phone",equalTo("123456"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json")
		.log().all();
		
}
	//@Test(priority = 2)
	void testDelete() {
		given()
		.when()
			.delete("http://localhost:3000/Students/9603")
		.then()
			.statusCode(200);
			
	}
}
