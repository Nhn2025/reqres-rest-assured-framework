package tests;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {

    String email, password;

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

        email = data.getString("email");
        password = data.getString("password");
    }

    @Test(priority = 2, dependsOnMethods = {"registerUser"})
    void loginUser() {
        JSONObject data = new JSONObject();
        data.put("email", email);
        data.put("password", password);

        Response response = given()
                .contentType("application/json")
                .body(data.toString())

        .when()
                .post("https://reqres.in/api/login");

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertNotNull(response.jsonPath().getString("token"));
    }

}
