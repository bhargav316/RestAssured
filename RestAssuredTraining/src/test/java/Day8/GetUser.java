package Day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	@Test
	void testGetUser(ITestContext context) {
		
		int id=(Integer) context.getSuite().getAttribute("user_id"); //this should come from create user request
		String bearerToken="ddceffeb47ca52a036b3ffbca396f6d56c5fb4c5f814314be1e2c130fe81f1da";
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.pathParam("id", id)
		
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
	}
}
