package tests.product;

import org.testng.annotations.BeforeMethod;

import api.ProductApi;
import io.restassured.response.Response;
import tests.base.BaseTest;
import utils.ConfigManager;

public class BaseProductFlowTest extends BaseTest {

	protected Response productResponse;
	
	@BeforeMethod(alwaysRun = true)
	protected void setupProductFlow() {
		int productId = Integer.parseInt(ConfigManager.get("default.product.id"));
		
		productResponse = ProductApi.getProductById(productId);
	}
}
