package com.mercadona.test.controller;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;
import com.mercadona.test.service.EanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/mercadona")
public class EanController {

    @Autowired
    private EanService eanService;

    @GetMapping("/{ean}")
    public ResponseEntity<EanResponse> getEan(@PathVariable BigDecimal ean) {
        final Ean eanProvider = new Ean(ean);
        EanResponse result = eanService.getInformation(eanProvider);
        return ResponseEntity.ok(result);
    }
}
