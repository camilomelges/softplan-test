package com.softplan.starwarscharacters.usecases.services;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

class RequestCharacterServiceTest {

    private RestTemplate restTemplate;

    @BeforeEach
    public void beforeEach() {

        CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        restTemplate = new RestTemplate(requestFactory);
    }

    @Test
    public void shouldBeReturnResponseSwapiDTOWithAnakin() {
        Assertions.assertEquals("Anakin Skywalker", new RequestCharacterService(restTemplate).getCharacter("anakin").getResults().get(0).getName());
    }

    @Test
    public void shouldBeReturnRuntimeExceptionWhenNotPassParams() {
        Assertions.assertThrows(RuntimeException.class, () -> new RequestCharacterService(restTemplate).getCharacter(""));
    }
}