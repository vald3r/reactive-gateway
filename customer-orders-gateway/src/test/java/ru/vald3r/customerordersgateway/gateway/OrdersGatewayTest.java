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
class OrdersGatewayTest {

    public static MockWebServer mockWebServer;
    @Autowired
    OrdersGateway ordersGateway;


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
    @DisplayName("Should get 3 orders by id=1")
    void getOrders() {

        MockResponse mockResponse = new MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .setBody("[{\"id\":1,\"productId\":1},{\"id\":3,\"productId\":1},{\"id\":4,\"productId\":2}]");

        mockWebServer.enqueue(mockResponse);
        StepVerifier.create(ordersGateway.getOrder(1L))
                .expectNextMatches(responseDto ->
                        responseDto != null && responseDto.size() == 3)
                .expectComplete()
                .verify();

    }
}