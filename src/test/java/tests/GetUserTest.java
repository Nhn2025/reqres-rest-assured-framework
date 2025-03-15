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

public class GetUserTest {

    int idCreate;
    int idRegister;

    @Test(priority = 1)
    void createUser() {
        HashMap data = new HashMap();
        data.put("name", "nhu");
        data.put("job", "tester");

        idCreate = given()
                .contentType("application/json")
                .body(data)

        .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    void getListUsers() {
        given()

        .when()
                .get("https://reqres.in/api/users?page=" + idCreate)

        .then()
                .statusCode(200)
                .body("page", equalTo(idCreate))
                .log().all();
    }

    @Test(priority = 3)
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
        idRegister = response.jsonPath().getInt("id");
    }

    @Test(priority = 4, dependsOnMethods = {"registerUser"})
    void getSingleUser() {
        given()

        .when()
                .get("https://reqres.in/api/users/" + idRegister)

        .then()
                .statusCode(200)
                .body("data.id", equalTo(idRegister));
    }

    @Test(priority = 5)
    void getSingleUserNotFound() {
        given()

        .when()
                .get("https://reqres.in/api/users/" + generateRandomNumber(4, 100000))

        .then()
                .statusCode(404);
    }

    public int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

}
