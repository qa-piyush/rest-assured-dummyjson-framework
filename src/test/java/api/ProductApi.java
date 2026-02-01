package api;

import client.ApiClient;
import io.restassured.response.Response;
import specs.RequestSpecFactory;

public class ProductApi {

	private static final String PRODUCTS_ENDPOINT = "/products";
	public static final String PROFILE_ENDPOINT = "/auth/products/1";
	private static final String PRODUCT_BY_ID_ENDPOINT = "/products/{id}";

	private ProductApi() {
	}

	public static Response getProfile() {
		return ApiClient.get(PROFILE_ENDPOINT, RequestSpecFactory.getAuthRequestSpec());
	}

	public static Response getProductById(int productId) {
		return ApiClient.get(PRODUCT_BY_ID_ENDPOINT.replace("{id}", String.valueOf(productId)),
				RequestSpecFactory.getRequestSpec());
	}
	
	public static Response createProduct(Object requestBody) {
		return ApiClient.put(PRODUCTS_ENDPOINT,
				RequestSpecFactory.getAuthRequestSpec(),
				requestBody);
	}
	
	public static Response deleteProduct(int productId) {
		return ApiClient.delete(PRODUCT_BY_ID_ENDPOINT.replace("{id}", String.valueOf(productId)),
				RequestSpecFactory.getAuthRequestSpec());
	}
}