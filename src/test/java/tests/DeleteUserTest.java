package tests;

import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class DeleteUserTest {

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
    void deleteUser() {
        given()

        .when()
                .delete("https://reqres.in/api/users/" + id)

        .then()
                .statusCode(204)
                .log().all();
    }

}
