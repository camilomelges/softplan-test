package com.softplan.valuewithtaxes.entrypoint;

import com.softplan.valuewithtaxes.entrypoint.entities.RequestDTO;
import com.softplan.valuewithtaxes.entrypoint.entities.ResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ValueWithTaxesControllerTest {

    @LocalServerPort
    private int localServerPort;
    private TestRestTemplate testRestTemplate;

    private String getRequestURL() {
        return "http://localhost:" + localServerPort + "/valueWithTaxes";
    }

    @BeforeEach
    public void beforeEach() {
        testRestTemplate = new TestRestTemplate();
    }

    @Test
    public void shouldBeReturnStatus500IfNotPassTax() {
        HttpEntity<RequestDTO> httpEntity = new HttpEntity<>(new RequestDTO());

        ResponseEntity<ResponseDTO> result = testRestTemplate.exchange(getRequestURL(), HttpMethod.POST, httpEntity, ResponseDTO.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }

    @Test
    public void shouldBeReturnStatus500IfNotPassAmount() {
        HttpEntity<RequestDTO> httpEntity = new HttpEntity<>(RequestDTO.builder().tax(2.2).build());

        ResponseEntity<ResponseDTO> result = testRestTemplate.exchange(getRequestURL(), HttpMethod.POST, httpEntity, ResponseDTO.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
    }

    @Test
    public void shouldBeReturnResponseDTOWithCorrectProduct() {
        RequestDTO requestDTO = RequestDTO.builder().tax(2.2).amount((long) 10000).build();
        HttpEntity<RequestDTO> httpEntity = new HttpEntity<>(requestDTO);

        ResponseEntity<ResponseDTO> result = testRestTemplate.exchange(getRequestURL(), HttpMethod.POST, httpEntity, ResponseDTO.class);
        Double valueWithTaxes = requestDTO.getAmount() + (requestDTO.getAmount() * (requestDTO.getTax() / 100));

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(valueWithTaxes, result.getBody().getValueWithTaxes());
    }
}