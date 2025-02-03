package finalProject;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class FinalProject_Response {

    public Response CreateOrder() {
        FinalProject_LombokData orderData = new FinalProject_LombokData();
        orderData.setId(1);
        orderData.setPetId(11);
        orderData.setQuantity(3);
        orderData.setStatus("placed");

        return given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(orderData)
                .when()
                .post("v2/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public Response GetOrder() {
        FinalProject_LombokData orderData = new FinalProject_LombokData();
        orderData.setId(1);
        orderData.setPetId(11);
        orderData.setQuantity(3);
        orderData.setStatus("placed");

        return given()
                .filter(new AllureRestAssured())
                .pathParam("orderId", orderData.getId())
                .accept(ContentType.JSON)
                .when()
                .get("v2/store/order/{orderId}")
                .then()
                .log().all()
                .extract().response();
    }

    public Response DeleteOrder() {
        FinalProject_LombokData orderData = new FinalProject_LombokData();
        orderData.setId(1);

        return given()
                .filter(new AllureRestAssured())
                .pathParam("orderId", orderData.getId())
                .accept(ContentType.JSON)
                .when()
                .delete("v2/store/order/{orderId}")
                .then()
                .log().all()
                .extract().response();
    }

    // -----------------------------------------------------  User Responses  --------------------------------------------------

    public Response CreateUser(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", Double.parseDouble(id));
        requestBody.put("username", username);
        requestBody.put("firstName", firstName);
        requestBody.put("lastName", lastName);
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("phone", phone);
        requestBody.put("userStatus", Double.parseDouble(userStatus));

        return given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("/v2/user")
                .then()
                .log().all()
                .extract().response();
    }

    public Response GetUser(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        return given()
                .filter(new AllureRestAssured())
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .get("v2/user/{username}")
                .then()
                .log().all()
                .extract().response();
    }

    public Response UpdateUser(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        String updatedName = "salo1";
        String updatedEmail = "salo1@gmail.com";
        String updatedPhone = "555123123";

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", Double.parseDouble(id));
        requestBody.put("username", username);
        requestBody.put("firstName", updatedName);
        requestBody.put("lastName", lastName);
        requestBody.put("email", updatedEmail);
        requestBody.put("password", password);
        requestBody.put("phone", updatedPhone);
        requestBody.put("userStatus", Double.parseDouble(userStatus));

        return given()
                .filter(new AllureRestAssured())
                .pathParam("username", username)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .put("v2/user/{username}")
                .then()
                .log().all()
                .extract().response();
    }

    public Response GetUpdatedUser(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {

        String updatedName = "salo1";
        String updatedEmail = "salo1@gmail.com";
        String updatedPhone = "555123123";

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", Double.parseDouble(id));
        requestBody.put("username", username);
        requestBody.put("firstName", updatedName);
        requestBody.put("lastName", lastName);
        requestBody.put("email", updatedEmail);
        requestBody.put("password", password);
        requestBody.put("phone", updatedPhone);
        requestBody.put("userStatus", Double.parseDouble(userStatus));

        return given()
                .filter(new AllureRestAssured())
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .get("v2/user/{username}")
                .then()
                .log().all()
                .extract().response();
    }

    public Response LogIn(String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        return given()
                .filter(new AllureRestAssured())
                .accept(ContentType.JSON)
                .queryParams("username", username, "password", password)
                .when()
                .get("v2/user/login")
                .then()
                .log().all()
                .extract().response();
    }

    public Response LogOut() {
        return given()
                .filter(new AllureRestAssured())
                .accept(ContentType.JSON)
                .when()
                .get("v2/user/logout")
                .then()
                .log().all()
                .extract().response();
    }

    public Response DeleteUser (String id, String username, String firstName, String lastName, String email, String password, String phone, String userStatus) {
        return given()
                .filter(new AllureRestAssured())
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .delete("/v2/user/{username}")
                .then()
                .log().all()
                .extract().response();
    }

    // -------------------------------------------------- For negative cases -------------------------------------------------------------------

    public Response InvalidOrder_1(String id) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("petId", 1);
        requestBody.put("quantity", 1);
        requestBody.put("status", "placed");

        return given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("v2/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public Response InvalidOrder_2(String petId) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("petId", petId);
        requestBody.put("quantity", 1);
        requestBody.put("status", "placed");

        return given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("v2/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public Response InvalidOrder_3(String quantity) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("petId", 1);
        requestBody.put("quantity", quantity);
        requestBody.put("status", "placed");

        return given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("v2/store/order")
                .then()
                .log().all()
                .extract().response();
    }
}
