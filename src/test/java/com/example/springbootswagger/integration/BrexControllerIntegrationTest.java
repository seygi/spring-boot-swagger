package com.example.springbootswagger.integration;

import com.example.springbootswagger.model.brex.BrexResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BrexControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetBrex() {
        // Arrange

        // Act
        ResponseEntity<BrexResponse> response = restTemplate.getForEntity("/api/v1/brex", BrexResponse.class);

        // Assert
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getData().get(0).getCompany(), is("Brex"));
    }
}

