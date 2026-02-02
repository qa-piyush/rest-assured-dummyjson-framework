package tests.product;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import api.ProductApi;
import io.restassured.response.Response;
import pojo.CreateProductRequest;
import tests.base.BaseTest;
import utils.ConfigManager;

public class BaseProductWriteFlowTest extends BaseTest {

	protected boolean setupCompleted = false;

	protected int createdProductId;

	@BeforeMethod(alwaysRun = true)
	public void setupProduct() {
		
		if (!Boolean.parseBoolean(
	            ConfigManager.get("product.write.enabled"))) {
	        throw new SkipException(
	                "Product write flows are disabled for this environment"
	        );
	    }
		CreateProductRequest createProductRequest = 
				new CreateProductRequest("Test Product", 999);

		Response response = ProductApi.createProduct(createProductRequest);
		
		if (response.getStatusCode() != 201) {
            throw new IllegalStateException("Product creation failed");
	}
		createdProductId = response.jsonPath().getInt("id");
        setupCompleted = true;
	}

	@AfterMethod(alwaysRun = true)
	public void cleanupProduct() {

		if (!setupCompleted) {
	        return; // setup never ran or was skipped
	    }
		if (createdProductId <= 0) {
			throw new IllegalStateException("Product creation failed, cannot cleanup");
		}
		ProductApi.deleteProduct(createdProductId);
	}
}
