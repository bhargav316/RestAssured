package Day4;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsingJSONObjectClass {
	
	@Test
	void testJSONResponseBodyData2() {
		
		 Response res = given()
			.contentType(ContentType.JSON)	 
		
		.when()
		.get("http://localhost:3000/book");
		 
		 JSONObject jo=new JSONObject(res.asString());
		 //search for title in the book in json - validation 1
		 boolean status=false;
		 
		 for (int i = 0; i < jo.getJSONArray("book").length(); i++)
		 {
			 String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			 if(bookTitle.equals("The Lord of the Rings")) {
				 status=true;
				 break;
			 }
			
		}
		 Assert.assertEquals(status, true);
		 
		 //validate total price of books -validation 2
		 double totalPrice=0;
		 for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			
			 String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			 totalPrice=totalPrice+ Double.parseDouble(price);
			 
			 
		}
		 System.out.println(totalPrice);
		 
		 
		 
	}
}
