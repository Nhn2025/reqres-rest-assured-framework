package tests;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

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

}
