package se.docker.alpine.build.gateway.api.v1;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PackageApiTest
{
    public static final String MY_PACKAGE = "myPackage";

    @Test
    @Order(1)
    public void testCollectionPostPackage()
    {
        given()
                .when().post("/v1/packages")
                .then()
                .header("Location", "http://localhost:64102/v1/packages/1")
                .statusCode(201);
    }

    @Test
    @Order(2)
    public void testCollectionGetPackage()
    {
        given()
                .when().get("/v1/packages")
                .then()
                .statusCode(200)
                .body(is("[http://localhost:64102/v1/packages/1]"));
    }


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