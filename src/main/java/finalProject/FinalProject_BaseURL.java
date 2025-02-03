package finalProject;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class FinalProject_BaseURL {
    @BeforeClass (description = "Base URL for API tests")
    public void baseURL(){
        RestAssured.baseURI = "https://petstore.swagger.io/";
    }
}
