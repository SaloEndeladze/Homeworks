import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseURL;

import static io.restassured.RestAssured.given;

public class ThirdTask_Homework2 extends BaseURL {

    @Test
    public void thirdTest(){
        LombokBuilder userData = LombokBuilder
                .builder()
                .userName("Test")
                .password("123")
                .build();

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userData)
                .when()
                .post("/Account/v1/user")
                .then()
                .log().all()
                .extract().response();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400, "Status code is 400");

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer."), "Message is correct");
    }
}
