package tests.product;

import base.BaseTest;
import client.ApiClient;
import io.restassured.response.Response;
import pojo.LoginRequest;
import specs.RequestSpecFactory;
import specs.ResponseSpecFactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductAuthTest extends BaseTest {

	@Test
	public void getProductWithAuth() {

		Response response = ApiClient.get("/auth/products/1",
				RequestSpecFactory.getAuthRequestSpec());

		response.then()
		.log().ifValidationFails()
		.spec(ResponseSpecFactory.successResponse());
	}

}
