import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseURL;

import static io.restassured.RestAssured.given;

public class SecondTask_APIHomework2 extends BaseURL {

    @Test
    public void secondTest(){
        LombokData userData = new LombokData();
        userData.setUserName("salome_endeladze5");
        userData.setPassword("Password123!");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(userData)
                .when()
                .post("/Account/v1/user")
                .then()
                .log().all()
                .extract().response();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201, "Status code is 201");

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("userID"), "Response contains userID");
    }
}
