package tests;

import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class CreateUserTest {

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

}
