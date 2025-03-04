package tests;

import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUserTest {

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
    void getUser() {
        given()

        .when()
                .get("https://reqres.in/api/users?page=" + id)

        .then()
                .statusCode(200)
                .body("page", equalTo(id))
                .log().all();
    }

}
