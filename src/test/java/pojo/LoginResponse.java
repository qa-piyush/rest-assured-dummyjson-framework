package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

	@JsonProperty("accessToken")
	private String accessToken;

	public LoginResponse() {
	}

	public String getAccessToken() {
		return accessToken;
	}
}
