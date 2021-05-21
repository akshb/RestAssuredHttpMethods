package HttpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Tests_GET {

	@Test
	public void test_1() {

		given().
		  header("Content_Type","application/json"). // key-value pair
		get("https://reqres.in/api/users?page=2").
		then().
		 statusCode(200).
		 body("data.id[1]" , equalTo(8)).  // Check from the response body that, from data array the id of 1th index is 8
		 body("data.first_name" , hasItems("Michael","Lindsay")).
		 log().all(); // To print response on the console

	}
}
