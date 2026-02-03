package specs;

import org.mozilla.javascript.ast.ConditionalExpression;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.TokenManager;

public class RequestSpecFactory {

	public static RequestSpecification getRequestSpec() {

		return new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.log(LogDetail.URI)
				.log(LogDetail.METHOD)
				.build();
	}

	public static RequestSpecification getAuthRequestSpec() {
		
		return new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization","Bearer " + TokenManager.getToken())
				.log(LogDetail.URI)
				.log(LogDetail.METHOD)
				.addFilter(new AllureRestAssured())
				.build();
	}
}