package com.mercadona.test.controller;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;
import com.mercadona.test.service.EanService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercadona")
public class EanController {

    @Autowired
    private EanService eanService;

    @GetMapping("/{ean}")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "All right."),
            @ApiResponse(responseCode = "404", description = "EAN not found"),
            @ApiResponse(responseCode = "500", description = "Service not available"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    public ResponseEntity<EanResponse> getEan(@PathVariable String ean) {
        final Ean eanProvider = new Ean(ean);
        EanResponse result = eanService.getInformation(eanProvider);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{ean}")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "All right."),
            @ApiResponse(responseCode = "404", description = "EAN not found"),
            @ApiResponse(responseCode = "500", description = "Service not available"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    public Ean createEan(@PathVariable String ean) {
        final Ean eanProvider = new Ean(ean);
        return eanService.insertEan(eanProvider);
    }

    @GetMapping("/all")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "All right."),
            @ApiResponse(responseCode = "404", description = "EAN not found"),
            @ApiResponse(responseCode = "500", description = "Service not available"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    public List<Ean> readEan() {
        return eanService.findAll();
    }

    @PutMapping("/{eanProvider}/{newEan}")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "All right."),
            @ApiResponse(responseCode = "404", description = "EAN not found"),
            @ApiResponse(responseCode = "500", description = "Service not available"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    public Ean updateEan(@PathVariable String eanProvider, @PathVariable String newEan) {
        return eanService.updateEan(eanProvider, newEan);
    }

    @DeleteMapping("/{ean}")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "All right."),
            @ApiResponse(responseCode = "404", description = "EAN not found"),
            @ApiResponse(responseCode = "500", description = "Service not available"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    public ResponseEntity<Void> deleteEan(@PathVariable String ean) {
        eanService.deleteEan(ean);
        return ResponseEntity.ok(null);
    }
}
