package com.mercadona.test.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ean {
    private String eanNumber;

    public Ean(String ean) {
        this.eanNumber = ean;
    }
}
