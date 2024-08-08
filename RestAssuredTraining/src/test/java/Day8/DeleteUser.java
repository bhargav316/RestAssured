package Day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class DeleteUser {

	@Test
	void testDeleteUser(ITestContext context) {
		
		String bearerToken="ddceffeb47ca52a036b3ffbca396f6d56c5fb4c5f814314be1e2c130fe81f1da";
		int id=(Integer) context.getSuite().getAttribute("user_id");
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
			.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
			.then()
			.statusCode(204)
			.log().all();
		
	}
	
	
}
