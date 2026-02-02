package tests.schema;

import org.testng.annotations.Test;

import api.AuthApi;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class AuthSchemaTest {

    @Test(groups = { "regression", "schema" })
    public void authProfileSchemaShouldMatch() {

        Response response = AuthApi.getProfile();

        response.then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/auth/profile-schema.json"));
    }
}