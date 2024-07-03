package com.nttdata.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class OrderManagementSteps {

    private RequestSpecification request;
    private Response response;

    @Given("I have an order payload with {string} and {string}")
    public void i_have_an_order_payload_with_and(String orderId, String petId) {
        // Prepare order payload here if needed
    }

    @When("I submit a POST request to create an order")
    public void i_submit_a_post_request_to_create_an_order() {
        request = RestAssured.given()
                .contentType("application/json")
                .body("{\"orderId\": \"1\", \"petId\": \"1\", \"quantity\": 1}");
        response = request.post("https://petstore.swagger.io/v2/store/order");
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer expectedStatusCode) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode.intValue(), statusCode);
    }

    @Given("I have an order ID {string}")
    public void i_have_an_order_id(String orderId) {
        // No preparation needed for this step
    }

    @When("I submit a GET request to retrieve the order")
    public void i_submit_a_get_request_to_retrieve_the_order() {
        response = RestAssured.get("https://petstore.swagger.io/v2/store/order/{orderId}", "1");
    }

    @Then("the order details for {string} should be returned successfully")
    public void the_order_details_for_should_be_returned_successfully(String orderId) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

        // Add more assertions for response body validation if needed
    }
}
