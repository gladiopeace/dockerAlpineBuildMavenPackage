package se.docker.alpine.build.gateway.api.v1;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PackageApiTest
{

    @Test
    public void testHelloEndpoint()
    {
        given()
                .when().get("/v1/packages")
                .then()
                .statusCode(200)
                .body(is("Hello"));
    }

    @Test
    public void testPostPackage()
    {
        given()
                .when().post("/v1/packages")
                .then()
                .header("Location", "http://localhost:64102/v1/packages/1")
                .statusCode(200);
    }

    @Test
    public void testPutNamePackage()
    {
        given()
                .when().put("/v1/packages/1/name")
                .then()
                .statusCode(200);
    }


    @Test
    public void testGetPackage()
    {
        given()
                .when().get("/v1/packages/1")
                .then()
                .statusCode(200)
                .body(is("{\"name\":\"mypackage\"}"));
    }

}