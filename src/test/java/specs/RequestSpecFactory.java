package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import utils.TokenManager;

public class RequestSpecFactory {

	public static RequestSpecification getRequestSpec() {

		return new RequestSpecBuilder()
				.setContentType("application/json")
				.log(LogDetail.URI)
				.log(LogDetail.METHOD)
				.build();
	}

	public static RequestSpecification getAuthRequestSpec() {
		
		return new RequestSpecBuilder()
				.setContentType("application/json")
				.addHeader("Authorization",
						"Bearer " + TokenManager.getToken())
				.log(LogDetail.URI)
				.log(LogDetail.METHOD)
				.build();
	}
}