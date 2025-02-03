package FinalProject;

import finalProject.FinalProject_BaseURL;
import finalProject.FinalProject_Response;
import finalProject.FinalProject_StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class FinalProject_NegativeCases extends FinalProject_BaseURL {

    private FinalProject_Response order = new FinalProject_Response();

    @Test (priority = 1)
    public void first() {

        Response response = order.InvalidOrder_1("test");

        FinalProject_StatusCode.statusCodeAndMessage(response, 500, "something bad happened");
    }

    @Test (priority = 2)
    public void second() {

        Response response = order.InvalidOrder_2("test");

        FinalProject_StatusCode.statusCodeAndMessage(response, 500, "something bad happened");
    }

    @Test (priority = 3)
    public void third() {

        Response response = order.InvalidOrder_3("test");

        FinalProject_StatusCode.statusCodeAndMessage(response, 500, "something bad happened");
    }
}
