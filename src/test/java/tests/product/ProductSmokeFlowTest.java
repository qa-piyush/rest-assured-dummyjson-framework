package tests.product;

import org.testng.annotations.Test;
import assertions.CommonAssertions;

public class ProductSmokeFlowTest extends BaseProductFlowTest{
	
	@Test(groups = {"smoke", "product"})
	public void userShouldGetProductById() {
		
		CommonAssertions.assertSuccess(productResponse);
	}
}
