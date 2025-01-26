package utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseURL {
    @BeforeTest (description = "Base URL for API tests")
    public void baseURL(){
        RestAssured.baseURI = "https://bookstore.toolsqa.com/";
    }
}
