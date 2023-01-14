package com.mercadona.test.controller;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;
import com.mercadona.test.service.EanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/mercadona")
public class EanController {

    @Autowired
    private EanService eanService;

    @GetMapping("/{ean}")
    public ResponseEntity<EanResponse> getEan(@PathVariable String ean) {
        final Ean eanProvider = new Ean(ean);
        EanResponse result = eanService.getInformation(eanProvider);
        return ResponseEntity.ok(result);
    }
}
