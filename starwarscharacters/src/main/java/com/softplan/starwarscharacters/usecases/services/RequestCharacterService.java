package com.softplan.starwarscharacters.usecases.services;

import com.softplan.starwarscharacters.usecases.entities.ResponseSwapiDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RequestCharacterService implements IRequestCharacterService {

    private final String swapiUrl = "https://swapi.dev/api/people";
    private final RestOperations restTemplate;

    public RequestCharacterService(final RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseSwapiDTO getCharacter(final String search) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(swapiUrl).queryParam("search", search);

            HttpEntity<?> entity = new HttpEntity<>(headers);

            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, ResponseSwapiDTO.class).getBody();
        } catch (Exception e) {
            throw new RuntimeException("Error occurred on request to ".concat(swapiUrl));
        }
    }
}
