package com.softplan.starwarscharacters.entrypoint;

import com.softplan.starwarscharacters.usecases.entities.StarWarsCharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CharactersControllerTest {

    @LocalServerPort
    private int localServerPort;
    private TestRestTemplate testRestTemplate;
    private String getRequestURL() {
        return "http://localhost:" + localServerPort + "/characters";
    }

    @BeforeEach
    public void beforeEach() {
        testRestTemplate = new TestRestTemplate();
    }

    @Test
    public void shouldBeReturnStatus500IfNotPassParams() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getRequestURL());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<StarWarsCharacterDTO> result = testRestTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, StarWarsCharacterDTO.class);

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    public void shouldBeReturnStatus500IfPassParamEmpty() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getRequestURL()).queryParam("search", "");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<StarWarsCharacterDTO> result = testRestTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, StarWarsCharacterDTO.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }

    @Test
    public void shouldBeReturnStatus200IfPassParamSearch() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getRequestURL()).queryParam("search", "anakin");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<StarWarsCharacterDTO> result = testRestTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, StarWarsCharacterDTO.class);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Anakin Skywalker", result.getBody().getName());
    }
}