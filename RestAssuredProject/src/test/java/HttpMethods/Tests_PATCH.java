package HttpMethods;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_PATCH {

	@Test
	public void test_3_patch() {

		JSONObject request = new JSONObject(); // we need proper json object format, need to add either json/json simple/gson/jackson dependency in pom.xml
		
		request.put("name", "Akshata");
		request.put("job", "Tester");
		
		System.out.println(request);
		
		given().
		   header("Content-Type","application/json"). // below 2 lines including this line needs to be added otherwise it shows only UpdatedAt in response body
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
	       body(request.toJSONString()).
		when().
		   patch("https://reqres.in/api/users/2"). //end point
		then().
		   statusCode(200).
		   log().all();
		
		
	}
	
}
