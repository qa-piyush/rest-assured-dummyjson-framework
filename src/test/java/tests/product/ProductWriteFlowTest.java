package tests.product;

import org.testng.annotations.Test;

import api.ProductApi;
import assertions.CommonAssertions;
import io.restassured.response.Response;

public class ProductWriteFlowTest extends BaseProductWriteFlowTest{

	@Test(groups = {"sanity","product"})
	public void userShouldCreateAndFetchProduct() {
		Response response = ProductApi.getProductById(createdProductId);
		CommonAssertions.assertSuccess(response);
}
}