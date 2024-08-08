package Day3;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class HeadersDemo {
	@Test
	void testHeader() {
		given()
		
		.when()
		.get("https://www.google.com")
		
		.then()
		.header("Content-Encoding", "gzip");
		
		
	}
}
