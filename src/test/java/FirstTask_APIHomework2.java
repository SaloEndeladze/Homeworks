import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseURL;

public class FirstTask_APIHomework2 extends BaseURL {

    @DataProvider(name = "isbn")
    public  Object[][] createIsbn(){
        return new Object[][]{
                {"9781449331818"},
                {"9781449337711"},
                {"9781449365035"},
                {"9781491904244"}
        };
    }

    @Test(dataProvider = "isbn")
    public void testIsbnData(String isbn){
        Response response = RestAssured
                .given()
                .queryParam("ISBN", isbn)
                .when()
                .get("/BookStore/v1/Book")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code should be 200");

        String checkIsbn = response.jsonPath().getString("isbn");
        Assert.assertEquals(checkIsbn, isbn, "ISBN is correct");

    }
}
