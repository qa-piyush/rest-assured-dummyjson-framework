package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import specs.RequestSpecFactory;

import static io.restassured.RestAssured.*;

public class SimpleGetTest extends BaseTest{

	@Test
	public void getProductTest() {
		
		given()
			.spec(RequestSpecFactory.getRequestSpec())
		.when()
			.get("/products/1")
		.then()
			.statusCode(200);
	}
}
