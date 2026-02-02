package tests.schema;

import org.testng.annotations.Test;

import api.ProductApi;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ProductSchemaTest {

    @Test(groups = { "regression", "schema" })
    public void productSchemaShouldMatch() {

        Response response = ProductApi.getProductById(1);

        response.then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/product/product-schema.json"));
    }
}
