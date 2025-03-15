package tests;

import io.restassured.response.Response;
import org.codehaus.groovy.tools.StringHelper;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetResources {

    @Test(priority = 1)
    void getListResources() {
        given()

        .when()
                .get("https://reqres.in/api/unknown")

        .then()
                .statusCode(200)
                .body("data[0].id", notNullValue())
                .body("data[0].name", notNullValue())
                .body("data[0].color", notNullValue())
                .body("data[0].year", notNullValue());
    }

    @Test(priority = 2)
    void getListResourcesNotFound() {
        given()

        .when()
                .get("https://reqres.in/api/unknown/" + generateRandomNumber(4, 100))

        .then()
                .statusCode(404)
                .body(equalTo("{}"));
    }

    public int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

}
