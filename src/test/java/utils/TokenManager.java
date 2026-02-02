package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.LoginRequest;
import pojo.LoginResponse;

public class TokenManager {

	private static String accessToken;
	private static long tokenGeneratedAt;
	private static long TOKEN_TTL_MS = 60_000;

	public static synchronized String getToken() {
		if (accessToken != null || isTokenExpired()) {
			 generateAndCacheToken();
		}
			return accessToken;
		}
	
	public static void generateAndCacheToken() {
		LoginRequest loginRequest = new LoginRequest(ConfigManager.get("auth.username"),
				ConfigManager.get("auth.password"));

		Response response = RestAssured
				.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(loginRequest)
				.post("/auth/login");

		LoginResponse loginResponse = response.as(LoginResponse.class);

		accessToken = loginResponse.getAccessToken();
	}
	
	public static synchronized void forceRefreshToken() {
	    accessToken = null;
	}

	private static boolean isTokenExpired() {
		return (System.currentTimeMillis() - tokenGeneratedAt) >= TOKEN_TTL_MS;
	}
}
