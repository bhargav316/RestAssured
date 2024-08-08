package Day6;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
public class JSONSchemeValidation {

	@Test
	void jsonschemavalidation() {
		
		given()
		
		.when()
		.get("http://localhost:3000/book")
		.then()
		.assertThat()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("StoreSchema.JSON"))
		.log().body();
		
	}
}
