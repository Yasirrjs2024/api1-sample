package com.yasir.api1sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Api1SampleApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void contextLoads() {
        // verifies Spring Boot context starts correctly
        assertThat(restTemplate).isNotNull();
    }
    @Test
    void helloEndpointShouldReturnGreeting() {
        // call GET /hello
        ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);
        // verify HTTP 200 and body content
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("Hello from api1");
    }
}
