package com.nttdata.Steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OrderUtils {
    private static final String BASE_URL = "http://localhost:8080"; // Ejemplo de URL base

    private static String orderId;
    private static String petId;
    private static Response response;

    public static void setOrderPayload(String orderId, String petId) {
        OrderUtils.orderId = orderId;
        OrderUtils.petId = petId;
    }

    public static void submitPostRequest() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        // Build your request payload as needed, e.g., JSON body
        String requestBody = "{\"orderId\": \"" + orderId + "\", \"petId\": \"" + petId + "\"}";

        // Send POST request and capture response
        response = request.body(requestBody).post("http://your.api.endpoint/createOrder");

        // Optional: Print response for debugging
        System.out.println("Response: " + response.asString());
    }

    public static void verifyStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    // Implement other verification methods as needed
}
