package tests.auth;

import org.testng.annotations.Test;
import assertions.CommonAssertions;
import client.ApiClient;
import io.restassured.response.Response;
import specs.RequestSpecFactory;
import tests.base.BaseTest;

public class AuthNegativeFlowTest extends BaseTest {

	@Test(groups = { "regression", "auth", "negative" })
	public void accessingProfileWithoutTokenShouldFail() {

		Response response = ApiClient.get( "/auth/me",
				RequestSpecFactory.getRequestSpec());

		CommonAssertions.assertUnauthorized(response);
	}
}