package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.TokenManager;

public class RequestSpecFactory {

	public static RequestSpecification getRequestSpec() {

		return new RequestSpecBuilder()
				.setContentType("application/json")
				.build();
	}

	public static RequestSpecification getAuthRequestSpec() {
		
		return new RequestSpecBuilder()
				.setContentType("application/json")
				.addHeader("Authorization",
						"Bearer " + TokenManager.getToken())
				.log(io.restassured.filter.log.LogDetail.ALL)
				.build();
	}
}