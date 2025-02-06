package FinalProject;

import finalProject.FinalProject_Response;
import finalProject.FinalProject_StatusCode;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import finalProject.FinalProject_BaseURL;
import finalProject.FinalProject_LombokData;


public class FinalProject_FirstScenario extends FinalProject_BaseURL {

    private FinalProject_Response order = new FinalProject_Response();

    @Test (priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Create new order")
    public void first() {
        Response response = order.CreateOrder();

        FinalProject_LombokData orderData = new FinalProject_LombokData();
        orderData.setId(1);
        orderData.setPetId(11);
        orderData.setQuantity(3);
        orderData.setStatus("placed");

        FinalProject_StatusCode.statusCode(response, 200);

        Assert.assertEquals(response.jsonPath().getInt("id"),orderData.getId(), "ID is not correct");
        Assert.assertEquals(response.jsonPath().getInt("petId"), orderData.getPetId(), "Pet ID is not correct");
        Assert.assertEquals(response.jsonPath().getInt("quantity"), orderData.getQuantity(), "Quantity is not correct");
        Assert.assertEquals(response.jsonPath().getString("status"), orderData.getStatus(), "Status is not correct");
    }

    @Test (priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get created order")
    public void second() {
        Response response = order.GetOrder();

        FinalProject_LombokData orderData = new FinalProject_LombokData();
        orderData.setId(1);
        orderData.setPetId(11);
        orderData.setQuantity(3);
        orderData.setStatus("placed");

        FinalProject_StatusCode.statusCode(response, 200);

        Assert.assertEquals(response.jsonPath().getInt("id"), orderData.getId(), "ID is not correct");
        Assert.assertEquals(response.jsonPath().getInt("petId"), orderData.getPetId(), "Pet ID is not correct");
        Assert.assertEquals(response.jsonPath().getInt("quantity"), orderData.getQuantity(), "Quantity is not correct");
        Assert.assertEquals(response.jsonPath().getString("status"), orderData.getStatus(), "Status is not correct");
    }

    @Test (priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete an order")
    public void third() {
        Response response = order.DeleteOrder();

        FinalProject_LombokData orderData = new FinalProject_LombokData();
        orderData.setId(1);

        FinalProject_StatusCode.statusCode(response, 200);
    }

    @Test (priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Try to delete already deleted order")
    public void fourth() {
        Response response = order.DeleteOrder();

        FinalProject_LombokData orderData = new FinalProject_LombokData();
        orderData.setId(1);

        FinalProject_StatusCode.statusCodeAndMessageWithContains(response, 404, "Order Not Found");
    }

    @Test (priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get deleted order")
    public void fifth() {
        Response response = order.GetOrder();

        FinalProject_LombokData orderData = new FinalProject_LombokData();
        orderData.setId(1);

        FinalProject_StatusCode.statusCodeAndMessageWithContains(response, 404, "Order not found");
    }
}
