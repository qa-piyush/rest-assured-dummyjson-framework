package tests.product;

import org.testng.annotations.Test;
import api.ProductApi;
import assertions.CommonAssertions;
import io.restassured.response.Response;
import tests.base.BaseTest;

public class ProductNegativeFlowTest extends BaseTest {

	@Test(groups = { "sanity", "product", "negative" })
	public void gettingInvalidProductShouldFail() {
		Response response = ProductApi.getProductById(0);

		CommonAssertions.assertStatus(response, 404);
	}
}
