package tests.product;

import base.BaseTest;
import io.restassured.specification.ResponseSpecification;
import specs.RequestSpecFactory;
import specs.ResponseSpecFactory;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetProductAuthTest extends BaseTest {

	@Test
	public void getProductWithAuth() {

		given()
			.spec(RequestSpecFactory.getAuthRequestSpec())
		.when()
			.get("/auth/products/1")
		.then()
			.spec(ResponseSpecFactory.successResponse());
	}
}
