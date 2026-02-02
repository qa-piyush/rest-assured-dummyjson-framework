package client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import utils.RetryPolicy;

public class ApiClient {

	public static Response get(String endpoint, RequestSpecification spec) {
		return executeWithRetry(() -> given().spec(spec).when().get(endpoint));
	}

	public static Response post(String endpoint, RequestSpecification spec, Object body) {
		return executeWithRetry(() -> given().spec(spec).body(body).when().post(endpoint));
	}

	public static Response put(String endpoint, RequestSpecification spec, Object body) {
		return executeWithRetry(() -> given().spec(spec).body(body).when().put(endpoint));
	}

	public static Response delete(String endpoint, RequestSpecification spec) {
		return executeWithRetry(() -> given().spec(spec).when().delete(endpoint));
	}

	private static Response executeWithRetry(RequestExecutor executor) {

		int attempts = 0;
		Response response = null;

		while (attempts < RetryPolicy.getMaxRetries()) {
			try {
				response = executor.execute();

				if (response.statusCode() < 500 || !RetryPolicy.isRetryEnabled()) {
					return response;
				}

			} catch (Exception e) {
				if (!RetryPolicy.isRetryEnabled()) {
					throw e;
				}
			}
		attempts++;
		sleep();
		}
		if (response == null) {
		    throw new RuntimeException("API call failed after retries — response is null");
		}
		return response;
	}

	private static void sleep() {
		try {
			Thread.sleep(RetryPolicy.getRetryDelayMs());
		} catch (InterruptedException ignored) {
		}
	}

	@FunctionalInterface
	private interface RequestExecutor {
		Response execute();
	}
	
}