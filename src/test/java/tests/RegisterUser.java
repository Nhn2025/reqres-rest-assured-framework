package tests;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RegisterUser {

    @Test(priority = 1)
    void registerUser() {
        JSONObject data = new JSONObject();
        data.put("email", "eve.holt@reqres.in");
        data.put("password", "pistol");

        Response response = given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://reqres.in/api/register");

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    void registerUserWithEmptyEmail() {
        JSONObject data = new JSONObject();
        data.put("email", "");
        data.put("password", "123456%43");

        given()
                .contentType("application/json")
                .body(data.toString())

        .when()
                .post("https://reqres.in/api/register")

        .then()
                .statusCode(400)
                .body("error", equalTo("Missing email or username"));
    }

    @Test(priority = 3)
    void registerUserWithEmptyPassword() {
        JSONObject data = new JSONObject();
        data.put("email", "abd@gmail.com");
        data.put("password", "");

        given()
                .contentType("application/json")
                .body(data.toString())

        .when()
                .post("https://reqres.in/api/register")

        .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

}
