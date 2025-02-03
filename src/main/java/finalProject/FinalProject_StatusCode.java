package finalProject;

import io.restassured.response.Response;
import org.testng.Assert;

public class FinalProject_StatusCode {

    public static void statusCode(Response response, int expectedStatusCode){

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, expectedStatusCode, "Expected status code is not correct");
    }

    public static void statusCodeAndMessageWithContains (Response response, int expectedStatusCode, String expectedMessage){

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, expectedStatusCode, "Expected status code is not correct");

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedMessage),"Response and expected message does not match");
    }

    public static void statusCodeAndMessage(Response response, int expectedStatusCode, String expectedMessage) {

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, expectedStatusCode, "Expected status code is not correct");

        String responseMessage = response.jsonPath().getString("message");
        Assert.assertEquals(responseMessage, expectedMessage, "Response and expected message does not match");
    }

}
