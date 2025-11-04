package com.example.java25demo.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerTest {
    @LocalServerPort
    int port;

    @Test
    void sayHello() {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
        UriComponents uriComponents = uriComponentsBuilder
                .scheme("http")
                .host("localhost")
                .port(port)
                .path("/hello/person")
                .pathSegment("{nameBlabla}")
                .queryParam("celebrity", "{mycelebrity}")
                .buildAndExpand("Mike Møller Nielsen", "Angela Surandon");
        String uriString = uriComponents.toUriString();
//        String uriStringHardcoded = "http://localhost:" + port + "/hello/person/Mike M?celebrity=Susan Merkel";
//        http:
//localhost:8080/hello/person/Mike Møller Nielsen?celebrity=Susan Nielsen
        String uriTemplate = "http://localhost:{port}/hello/person/{person}?celebrity={celebrity}";
//        System.out.println(uriString);
//        String result = restTemplate.getForObject(uriString, String.class);
//        String result = restTemplate.getForObject(uriStringHardcoded, String.class);
        String result = restTemplate.exchange(RequestEntity
                        .get(uriTemplate, port, "Mike MN", "Donna Jolie").build(),
                String.class).getBody();
        System.out.println(result);
    }
}