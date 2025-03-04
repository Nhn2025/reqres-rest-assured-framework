package tests;

import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest {

    @Test(priority = 1)
    void createUser() {
        HashMap data = new HashMap();
        data.put("name", "nhu");
        data.put("job", "tester");

        given()
                .contentType("application/json")
        .body(data)

        .when()
                .post("https://reqres.in/api/users")

        .then()
                .statusCode(201)
                .body("name", equalTo("nhu"))
                .body("job", equalTo("tester"));
    }

}
