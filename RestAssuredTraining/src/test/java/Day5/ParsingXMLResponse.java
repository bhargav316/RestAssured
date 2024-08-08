package Day5;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingXMLResponse {

	@Test
	void testXmlResponse() {
		
		given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		.statusCode(200)
		.header("Content-Type","application/xml");
	}
}
