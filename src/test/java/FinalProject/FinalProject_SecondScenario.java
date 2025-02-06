package FinalProject;

import finalProject.FinalProject_BaseURL;
import finalProject.FinalProject_Response;
import finalProject.FinalProject_StatusCode;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.io.IOException;

public class FinalProject_SecondScenario extends FinalProject_BaseURL {

    private FinalProject_Response user = new FinalProject_Response();

    @DataProvider(name = "userData")
    public Object[][] getUserData() throws IOException {
        return ExcelReader.getTestData("src/main/resources/final_project_test_data.xlsx", "Sheet1").toArray(new Object[0][0]);
    }

    @Test(dataProvider = "userData", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create user")
    public void first(String  id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        Response response = user.CreateUser(id, username, firstName, lastName, email, password, phone, userStatus);

        FinalProject_StatusCode.statusCode(response, 200);
    }

    @Test(dataProvider = "userData", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get created user")
    public void second(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        Response response = user.GetUser(id, username, firstName, lastName, email, password, phone, userStatus);

        FinalProject_StatusCode.statusCode(response, 200);

        String responseUsername = response.jsonPath().getString("username");
        Assert.assertEquals(responseUsername, username, "Username is not correct");

        String responseFirstName = response.jsonPath().getString("firstName");
        Assert.assertEquals(responseFirstName, firstName, "First name is not correct");

        String responseLastName = response.jsonPath().getString("lastName");
        Assert.assertEquals(responseLastName, lastName, "Last name is not correct");

        String responseEmail = response.jsonPath().getString("email");
        Assert.assertEquals(responseEmail, email, "Email is not correct");

        String responsePassword = response.jsonPath().getString("password");
        Assert.assertEquals(responsePassword, password, "Password is not correct");

        String responsePhone = response.jsonPath().getString("phone");
        Assert.assertEquals(responsePhone, phone, "Phone is not correct");

        String responseUserStatus = response.jsonPath().getString("userStatus");
        Assert.assertEquals(Double.parseDouble(responseUserStatus), Double.parseDouble(userStatus), "User status is not correct");

    }

    @Test (dataProvider = "userData", priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Update user")
    public void third(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        Response response = user.UpdateUser(id, username, firstName, lastName, email, password, phone, userStatus);

        FinalProject_StatusCode.statusCode(response, 200);
    }

    @Test (dataProvider = "userData", priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get updated user")
    public void fourth(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        String updatedName = "salo1";
        String updatedEmail = "salo1@gmail.com";
        String updatedPhone = "555123123";

        Response response = user.GetUpdatedUser(id, username, firstName, lastName, email, password, phone, userStatus);

        FinalProject_StatusCode.statusCode(response, 200);

        String responseName = response.jsonPath().getString("firstName");
        String responseEmail = response.jsonPath().getString("email");
        String responsePhone = response.jsonPath().getString("phone");

        Assert.assertEquals(responseName, updatedName, "Name was not updated");
        Assert.assertEquals(responseEmail, updatedEmail, "Email was not updated");
        Assert.assertEquals(responsePhone, updatedPhone, "Phone was not updated");
    }

    @Test (dataProvider = "userData", priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Log in to system")
    public void fifth(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus){

        Response response = user.LogIn(id, username, firstName, lastName, email, password, phone, userStatus);

        FinalProject_StatusCode.statusCode(response, 200);

        Assert.assertNotNull(response.jsonPath().getString("message"),"Message is empty");
    }

    @Test (priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Log out from system")
    public void sixth(){

        Response response = user.LogOut();

        FinalProject_StatusCode.statusCodeAndMessageWithContains(response, 200, "ok");
    }

    @Test (dataProvider = "userData", priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete user")
    public void seventh(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        Response response = user.DeleteUser(id, username, firstName, lastName, email, password, phone, userStatus);

        FinalProject_StatusCode.statusCodeAndMessageWithContains(response, 200, username);
    }
}