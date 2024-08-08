package Day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {

	@Test(priority = 1)
	void testBasicAuthentication() {
		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		
		.body("authenticated",equalTo(true))
		.log().all();
		
		
	}
	@Test(priority = 2)
	void testDigestAuthentication() {
		given()
		.auth().digest("postman", "password")
		.when()
		
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
		
	}
	@Test(priority = 3)
	void testPreemptiveAuthentication() {
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
		
	}
	@Test
	void testBearerTokenAuthentication() {
		String bearerToken="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";
		given()
			.headers("Authorization","Bearer "+bearerToken)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
	@Test
	void testOAuth2Authentication() {
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
	}
	
}