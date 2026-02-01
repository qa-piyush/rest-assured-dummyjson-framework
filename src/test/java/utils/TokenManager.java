package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.LoginRequest;
import pojo.LoginResponse;

public class TokenManager {

	public static String getToken() {
		return generateToken();
	}

	private static String generateToken() {

		LoginRequest loginRequest = new LoginRequest(ConfigManager.get("auth.username"),
				ConfigManager.get("auth.password"));

		Response response = RestAssured.given()
				.contentType("application/json")
				.accept("application/json")
				.body(loginRequest)
				.post("/auth/login");

		LoginResponse loginResponse = response.as(LoginResponse.class);

		return loginResponse.getAccessToken();
	}
}
