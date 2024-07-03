package com.nttdata.Steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OrderUtils {
    private static final String BASE_URL = "https://petstore.swagger.io/v2"; // URL base de PetStore

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

        // Construir el cuerpo de la solicitud JSON según sea necesario
        String requestBody = "{\"id\": " + orderId + ", \"petId\": " + petId + ", \"quantity\": 1, \"shipDate\": \"2024-07-04T10:10:10.381Z\", \"status\": \"placed\", \"complete\": true}";

        // Enviar la solicitud POST y capturar la respuesta
        response = request.body(requestBody).post(BASE_URL + "/store/order");

        // Opcional: Imprimir la respuesta para depuración
        System.out.println("Response: " + response.asString());
    }

    public static void submitGetRequest(String orderId) {
        RequestSpecification request = RestAssured.given();

        // Enviar la solicitud GET y capturar la respuesta
        response = request.get(BASE_URL + "/store/order/" + orderId);

        // Opcional: Imprimir la respuesta para depuración
        System.out.println("Response: " + response.asString());
    }

    public static void verifyStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }


}
