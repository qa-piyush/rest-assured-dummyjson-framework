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
		
		
		 System.out.println("LOGIN STATUS: " + response.statusCode());
		    System.out.println("LOGIN BODY: " + response.asString());

		 
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println("TOKEN FROM POJO: " + loginResponse.getAccessToken());
				
		return loginResponse.getAccessToken();
	}
}
