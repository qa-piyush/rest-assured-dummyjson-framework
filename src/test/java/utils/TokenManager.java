package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.LoginRequest;
import pojo.LoginResponse;

public class TokenManager {

	private static String accessToken;
	
	public static String getToken() {
//		if(accessToken == null)
//		{
//			accessToken = generateToken();
//		}
//		return accessToken;
		return generateToken();
	}

	private static String generateToken() {
		
		LoginRequest loginRequest = new LoginRequest("emilys", "emilyspass");
		
		Response response = RestAssured
				.given()
				.contentType("application/json")
				.accept("application/json")
				.body(loginRequest)
				.post("/auth/login");
		 
		LoginResponse loginResponse = response.as(LoginResponse.class);
				
		return loginResponse.getAccessToken();
	}
}
