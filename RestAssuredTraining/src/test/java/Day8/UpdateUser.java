package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	void testUpdateUser(ITestContext context) {
		
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		
		String bearerToken="ddceffeb47ca52a036b3ffbca396f6d56c5fb4c5f814314be1e2c130fe81f1da";
		int id=(Integer) context.getSuite().getAttribute("user_id");
		given()
		.headers("Authorization","Bearer "+ bearerToken)
		.contentType("application/json")
		.pathParam("id", id)
		.body(data.toString())
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
}
