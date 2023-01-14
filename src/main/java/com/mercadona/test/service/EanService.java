package com.mercadona.test.service;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;

import java.util.List;

public interface EanService {
    EanResponse getInformation(Ean ean);

    Ean insertEan(Ean ean);

    List<Ean> findAll();

    Ean updateEan(String ean, String newEan);

    void deleteEan(String ean);
}
