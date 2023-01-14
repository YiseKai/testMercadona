package com.mercadona.test.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EanResponse {
    String provider;
    String productCode;
    String address;

    public EanResponse() {
        //Nothing to do
    }

    public EanResponse(String provider, String productCode, String address) {
        this.provider = provider;
        this.productCode = productCode;
        this.address = address;
    }
}
