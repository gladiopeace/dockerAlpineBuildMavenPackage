package se.docker.alpine.build.gateway.api.v1;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.matchesPattern;


@DisplayName("Restful tests")
@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PackageApiTest
{
    public static final String MY_PACKAGE = "myPackage";

    @DisplayName("Creates a member resource in the collection resource. " +
            "The URI of the created member resource is automatically assigned and returned " +
            "in the response Location header field. ")
    @Test
    @Order(1)
    public void testCollectionPostPackage()
    {
        given()
                .when().post("/v1/packages")
                .then()
                .header("Location", matchesPattern("http://localhost:[0-9]+/v1/packages/1"))
                .statusCode(201);
    }

    @DisplayName("Retrieves the URIs of the member resources of the collection resource in the response body")
    @Test
    @Order(2)
    public void testCollectionGetPackage()
    {
        given()
                .when().get("/v1/packages")
                .then()
                .statusCode(200)
                .body(matchesPattern("\\[http://localhost:[0-9]+/v1/packages/1\\]"));
    }


    @DisplayName("Replaces all the representations of the member resource or create the member resource if it does not exist, with the representation in the request body.")
    @Test
    @Order(10)
    public void testMemberPutNamePackage()
    {
        given()
                .body(MY_PACKAGE)
                .when().put("/v1/packages/1/name")
                .then()
                .statusCode(200);
    }

    @DisplayName("Retrieve representation of the member resource in the response body")
    @Test
    @Order(11)
    public void testMemberGetPackage()
    {
        given()
                .when().get("/v1/packages/1")
                .then()
                .statusCode(200)
                .body(is("{\"name\"" +
                        ":\"" + MY_PACKAGE + "\"}"));
    }
}