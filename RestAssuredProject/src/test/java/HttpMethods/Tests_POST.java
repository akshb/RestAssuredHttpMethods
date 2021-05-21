package HttpMethods;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Tests_POST {

	@Test
	public void test_1_post() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("name", "Akshata");
//		map.put("job", "Tester");
//		
//		System.out.println(map);  // This will work, but we need proper json object format, need to add either json/json simple/gson/jackson dependency in pom.xml
//		
//		JSONObject request = new JSONObject(map);
//		
//		System.out.println(request);
//		
		
		// ..........................OR...........................
		
		JSONObject request = new JSONObject(); // we need proper json object format, need to add either json/json simple/gson/jackson dependency in pom.xml
		
		request.put("name", "Akshata");
		request.put("job", "Tester");
		
		System.out.println(request);
		
		given().
	       body(request.toJSONString()).
		when().
		   post("https://reqres.in/api/users"). //end point
		then().
		   statusCode(201); // 201 Created: when post request
		
		
	}
	
}
