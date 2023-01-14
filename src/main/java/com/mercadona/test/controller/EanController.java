package com.mercadona.test.controller;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;
import com.mercadona.test.service.EanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@RestController
public class EanController {

    private EanService eanService;

    @GetMapping(
            path = { "/{ean}" },
            consumes = {"application/json"}
    )
    public ResponseEntity<EanResponse> getEan(@PathVariable("EAN") BigDecimal ean) {
        final Ean eanProvider = new Ean(ean);
        EanResponse result = eanService.getInformation(eanProvider);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
