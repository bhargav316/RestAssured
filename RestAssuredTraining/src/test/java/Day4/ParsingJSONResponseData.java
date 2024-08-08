package Day4;
import static io.restassured.RestAssured.given;

import java.util.Iterator;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJSONResponseData {

	@Test(priority = 1)
	void testJSONResponse() {
		//Approach1
//		given()
//		.contentType("ContentType.JSON")
//		
//		.when()
//		.get("http://localhost:3000/book")
//		
//		
//		.then()
//		.statusCode(200)
//		.header("Content-Type", "application/json")
//		.body("book[3].title",equalTo("The Lord of the Rings"));
		Response res = given()
		.log().all()
		
		.when()
		.get("http://localhost:3000/book");
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200); //validation1
		Assert.assertEquals(res.header("Content-Type"), "application/json"); //validation2
		
		String Bookname=res.jsonPath().get("[3].title").toString();
		System.out.println(Bookname);
		Assert.assertEquals(Bookname, "The Lord of the Rings");
		//JSON Object Class
		JSONObject jo=new JSONObject(res.toString()); //converting response to json object type
		
		for(int i=0; i<jo.getJSONArray("book").length(); i++) {
			
			String BookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		}
		
		
		
		
		
		
		
	}
}
