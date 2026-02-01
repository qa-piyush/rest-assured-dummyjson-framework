package tests.auth;

import org.testng.annotations.BeforeMethod;
import api.AuthApi;
import io.restassured.response.Response;
import tests.base.BaseTest;

public class BaseAuthFlowTest extends BaseTest{

	protected Response profileResponse;
	
	@BeforeMethod(alwaysRun = true)
	protected void setupAuthFlow() {
		profileResponse = AuthApi.getProfile();
	}
}