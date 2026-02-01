package assertions;

import io.restassured.response.Response;
import specs.ResponseSpecFactory;

public class CommonAssertions {

	private CommonAssertions() {
	}
	
	public static void assertSuccess(Response response) {
		response.then()
				.log().ifValidationFails()
				.spec(ResponseSpecFactory.successResponse());
	}
	
	public static void assertUnauthorized(Response response) {
		response.then()
				.log().ifValidationFails()
				.spec(ResponseSpecFactory.unauthorizedResponse());
	}
	
	public static void assertBadRequest(Response response) {
		response.then()
				.log().ifValidationFails()
				.statusCode(400);
	}
	
	public static void assertStatus(Response response, int expectedStatusCode) {
		response.then()
				.log().ifValidationFails()
				.statusCode(expectedStatusCode);
	}
}
