package com.mercadona.test.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Ean {
    private BigDecimal eanNumber;

    public Ean(BigDecimal ean) {
        this.eanNumber = ean;
    }
}
