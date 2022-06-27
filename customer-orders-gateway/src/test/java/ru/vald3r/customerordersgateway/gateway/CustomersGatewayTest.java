package ru.vald3r.customerordersgateway.gateway;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.io.IOException;

@SpringBootTest
class CustomersGatewayTest {
    public static MockWebServer mockWebServer;
    @Autowired
    CustomersGateway customersGateway;

    @BeforeAll
    static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start(8080);
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    @DisplayName("Should get customer Igor by id=1")
    void getCustomer() {
        MockResponse mockResponse = new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody("{\"id\": 1,\"name\": \"Igor\"}");

        mockWebServer.enqueue(mockResponse);
        StepVerifier.create(customersGateway.getCustomer(1L))
                .expectNextMatches(responseDto ->
                        responseDto != null && responseDto.getName().equals("Igor"))
                .expectComplete()
                .verify();
    }
}