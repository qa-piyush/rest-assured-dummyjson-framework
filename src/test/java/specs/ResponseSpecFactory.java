package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecFactory {
	
	public static ResponseSpecification successResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }
	
	public static ResponseSpecification unauthorizedResponse() {

	    return new ResponseSpecBuilder()
	            .expectStatusCode(401)
	            .build();
	}
}


