package tests.auth;

import org.testng.annotations.Test;
import assertions.CommonAssertions;

public class AuthSmokeFlowTest extends BaseAuthFlowTest {

	@Test(groups = { "smoke", "auth" })
	public void userShouldAccessProfileAfterLogin() {

		CommonAssertions.assertSuccess(profileResponse);
	}
}
