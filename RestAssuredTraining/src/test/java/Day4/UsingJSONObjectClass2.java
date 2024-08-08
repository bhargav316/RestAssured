
	package Day4;

	import static io.restassured.RestAssured.given;

	import org.json.JSONArray;
	import org.json.JSONObject;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;
	import io.restassured.response.Response;

	public class UsingJSONObjectClass2 {
		
		@Test
		void testJSONResponseBodyData2() {
			
			Response res = given()
				.contentType(ContentType.JSON)	 
				.when()
				.get("http://localhost:3000/book");
			 
			JSONArray books = new JSONArray(res.asString());
			
			// Search for title in the book in JSON - validation 1
			boolean status = false;
			for (int i = 0; i < books.length(); i++) {
				String bookTitle = books.getJSONObject(i).getString("title");
				if (bookTitle.equals("The Lord of the Rings")) {
					status = true;
					break;
				}
			}
			Assert.assertTrue(status, "The book 'The Lord of the Rings' was not found.");
			 
			// Validate total price of books - validation 2
			double totalPrice = 0;
			for (int i = 0; i < books.length(); i++) {
				double price = books.getJSONObject(i).getDouble("price");
				totalPrice += price;
			}
			System.out.println("Total price of all books: " + totalPrice);
		}
	}
