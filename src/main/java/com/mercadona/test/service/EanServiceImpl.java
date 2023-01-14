package com.mercadona.test.service;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;
import com.mercadona.test.utils.EanHandler;
import org.springframework.stereotype.Service;

@Service
public class EanServiceImpl implements EanService{

    private EanHandler eanHandler;

    @Override
    public EanResponse getInformation(Ean ean) {
        eanHandler = new EanHandler();
        return eanHandler.toDomain(ean);
    }
}
