package com.mercadona.test.service;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;

public interface EanService {
    EanResponse getInformation(Ean ean);
}
