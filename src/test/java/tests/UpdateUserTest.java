package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserTest {

    int id;

    @Test(priority = 1)
    void createUser() {
        HashMap data = new HashMap();
        data.put("name", "nhu");
        data.put("job", "tester");

        id = given()
                .contentType("application/json")
                .body(data)

        .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    void updateUserUsingPut() {
        HashMap data = new HashMap();
        data.put("name", "rua");
        data.put("job", "auto");

        given()
                .contentType("application/json")
                .body(data)

        .when()
                .put("https://reqres.in/api/users/" + id)

        .then()
                .statusCode(200)
                .body("name", equalTo("rua"))
                .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUserUsingPatch() {
        HashMap dataUser = new HashMap();
        dataUser.put("name", "hoax");
        dataUser.put("job", "auto/manual");

        Response response = given()
                                .contentType("application/json")
                                .body(dataUser)
                            .when()
                                .patch("https://reqres.in/api/users/" + id);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "hoax");
        Assert.assertEquals(response.jsonPath().getString("job"), "auto/manual");
    }

}
