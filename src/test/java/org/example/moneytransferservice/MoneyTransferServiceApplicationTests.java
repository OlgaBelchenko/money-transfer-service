package org.example.moneytransferservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoneyTransferServiceApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Container
    private final GenericContainer<?> transferContainer = new GenericContainer<>("money-transfer:latest")
            .withExposedPorts(5500);

    @Test
    void testContainerStartPage() {
        Integer port = transferContainer.getMappedPort(5500);
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port, String.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(404));
    }
}
