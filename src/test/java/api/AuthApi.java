package api;

import client.ApiClient;
import io.restassured.response.Response;
import specs.RequestSpecFactory;

public class AuthApi {
	
	public static final String PROFILE_ENDPOINT = "/auth/me";
	
	private AuthApi() {
	}

	public static Response getProfile() {
		return ApiClient.get(PROFILE_ENDPOINT,
				RequestSpecFactory.getAuthRequestSpec());
	}
}
