import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class homework_APITest {

    @BeforeTest
    public void baseURL(){
        RestAssured.baseURI = "https://bookstore.toolsqa.com/";
    }

    @Test
    public void first(){
        Response response = given()
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is 200");

        String author = response.jsonPath().getString("books[0].author");
        String publisher = response.jsonPath().getString("books[0].publisher");
        Assert.assertEquals(author, "Richard E. Silverman", "Author is correct");
        Assert.assertEquals(publisher, "O'Reilly Media", "Publisher is correct");
    }

    @Test
    public void second(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", "Salo_endeladze");
        requestBody.put("password", "Password123!");

        Response response = given()
                .header("accept","application/json")
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/user")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201, "Status code is 201");

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("userID"), "Response contains userID");
    }

    @Test
    public void third(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("userName", "Test");
        requestBody.put("password", "123");

        Response response = given()
                .header("accept","application/json")
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .post("/Account/v1/user")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400, "Status code is 400");

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer."), "Message is correct");
    }

    /* ასეც მუშაობდა, თუმცა ვარჩიე ნაკლები ჩანაწერი მქონოდა და ზემოთ რაც გამოვიყენე ის დავტოვე:
        String path1 = "BookStore";
        String path2 = "v1";
        String path3 = "Books";

        Response response = given()
                .pathParam("path1", path1)
                .pathParam("path2", path2)
                .pathParam("path3", path3)
                .when()
                .get("/{path1}/{path2}/{path3}")
                .then()
                .extract().response();
    */
}
