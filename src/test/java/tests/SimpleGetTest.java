package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import client.ApiClient;
import io.restassured.response.Response;
import specs.RequestSpecFactory;

public class SimpleGetTest extends BaseTest {

	@Test
	public void getProductTest() {
		Response response = ApiClient.get("/products/1",
				RequestSpecFactory.getRequestSpec());
		
		response.then()
			    .statusCode(200);
	}
}