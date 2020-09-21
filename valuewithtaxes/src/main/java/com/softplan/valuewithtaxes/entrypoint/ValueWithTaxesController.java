package com.softplan.valuewithtaxes.entrypoint;

import com.softplan.valuewithtaxes.entrypoint.entities.RequestDTO;
import com.softplan.valuewithtaxes.entrypoint.entities.ResponseDTO;
import com.softplan.valuewithtaxes.entrypoint.exceptions.ResponseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@RestController
@RequestMapping("/valueWithTaxes")
public class ValueWithTaxesController {

    @PostMapping
    public ResponseDTO post(final @RequestBody RequestDTO requestDTO) {
        if (requestDTO.getTax() == null) {
            throw new ResponseException("Tax cannot be null");
        }

        if (requestDTO.getAmount() == null) {
            throw new ResponseException("Amount cannot be null");
        }

        Double valueWithTaxes = requestDTO.getAmount() + (requestDTO.getAmount() * (requestDTO.getTax() / 100));

        return ResponseDTO.builder().valueWithTaxes(valueWithTaxes).build();
    }
}
