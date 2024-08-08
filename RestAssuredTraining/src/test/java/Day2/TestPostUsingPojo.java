package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class TestPostUsingPojo {
	@Test(priority = 1)
	void testPostUsingPj() {
		
		PojoVariables data=new PojoVariables();
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("123456");
		String coursesArr[]= {"C","C++"};
		data.setCourses(coursesArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
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
