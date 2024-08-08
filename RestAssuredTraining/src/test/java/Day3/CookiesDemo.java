package Day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
@Test
public void getCookies()
{
	Response res = given()
	
	.when()
	.get("https://www.google.com");
	
	Map<String, String> COOKIE_VALUES = res.getCookies();
	for (String k : COOKIE_VALUES.keySet()) {
		String COOKIE_VALUE=res.getCookie(k);
		System.out.println(COOKIE_VALUE);
		
	}
	
	
	
	
	
}
}
