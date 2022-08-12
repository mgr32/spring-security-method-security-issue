package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractMethodSecurityTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void endpointAllowingROLE_GUESTshouldAllowGuest() {
        var response = executeBasicAuthRequest("/helloRoleGuest", CommonSecurityConfiguration.USER_GUEST);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void endpointAllowingGUESTshouldAllowGuest() {
        var response = executeBasicAuthRequest("/helloGuest", CommonSecurityConfiguration.USER_GUEST);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private ResponseEntity<String> executeBasicAuthRequest(String url, UserDetails role) {
        return restTemplate.exchange(url, HttpMethod.GET, buildBasicAuthRequest(role), String.class);
    }

    private HttpEntity<?> buildBasicAuthRequest(UserDetails user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(user.getUsername(), user.getPassword().replace("{noop}", ""));
        return new HttpEntity<>(headers);
    }
}
