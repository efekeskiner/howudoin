package com.example.howudoin.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloEndpointReturnsExpectedMessage() {
        // Act: Call the root endpoint
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

        // Assert: Check if the response matches "Hello, Howudoin!"
        assertThat(response.getBody()).isEqualTo("Hello, Howudoin!");
    }
}
