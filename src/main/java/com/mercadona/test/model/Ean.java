package com.mercadona.test.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Ean {
    public BigDecimal ean;

    public Ean(BigDecimal ean) {
        this.ean = ean;
    }
}
