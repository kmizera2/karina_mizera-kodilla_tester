package com.kodilla.rest.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderUpdateTest {

    @Test
    public void shouldUpdatePost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String updatedPostJson = """
            {
              "id": 1,
              "title": "Updated Title",
              "body": "Updated body content",
              "userId": 1
            }
            """;

        given()
                .header("Content-type", "application/json")
                .body(updatedPostJson)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", equalTo("Updated Title"))
                .body("body", equalTo("Updated body content"))
                .body("userId", equalTo(1));
    }
}
