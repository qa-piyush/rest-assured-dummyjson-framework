package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import client.ApiClient;
import io.restassured.response.Response;
import pojo.LoginRequest;
import specs.RequestSpecFactory;
import specs.ResponseSpecFactory;

public class LoginTest {

	@Test(dataProvider = "invalidLoginData" )
	public void loginNegativeTest(String username, String password) {
		
		LoginRequest loginRequest = new LoginRequest(username, password);
		
		Response response = ApiClient.post("/auth/login", 
				RequestSpecFactory.getRequestSpec(), loginRequest);
		
		response.then()
				.log().ifValidationFails()
				.spec(ResponseSpecFactory.successResponse());
	}

    @DataProvider(name = "invalidLoginData")
    public Object invalidLoginData() {
	return new Object[][] {
		{"emilys", "emilyspass"},
		{"wrongUser", "wrongPass"},
        {"", "password"},
        {"user", ""}
	 };
    }
   }