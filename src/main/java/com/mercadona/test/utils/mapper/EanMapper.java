package com.mercadona.test.utils.mapper;

import com.mercadona.test.model.EanResponse;

import java.math.BigDecimal;

public class EanMapper {

    static final String MERCADONA_SPAIN = "Tiendas Mercadona España";
    static final String MERCADONA_PORTUGAL = "Tiendas Mercadona Portugal";
    static final String ALMACEN = "Almacenes";
    static final String MERCADONA_OFICINA = "Oficinas Mercadona";
    static final String COLMENAS = "Colmenas";
    static final int MERCADONA_PROVIDER = 8437008;
    static final String HACENDADO = "Hacendado";
    static final String OTHER_PROVIDER = "Otro proveedor";

    public EanResponse mapToEanResponse(BigDecimal provider, BigDecimal product, BigDecimal address) {
        return new EanResponse(mapToProvider(provider), mapToProduct(product), mapToDestiny(address));
    }

    private String mapToDestiny(BigDecimal address) {
        String result = "";
        switch (String.valueOf(address)) {
            case "1": case "2": case "3": case "4": case "5": result = MERCADONA_SPAIN; break;
            case "6": result = MERCADONA_PORTUGAL; break;
            case "8": result = ALMACEN; break;
            case "9": result = MERCADONA_OFICINA; break;
            case "0": result = COLMENAS; break;
        }
        return result;
    }

    private String mapToProvider(BigDecimal provider) {
        if(provider.equals(new BigDecimal(MERCADONA_PROVIDER))) {
            return HACENDADO;
        } else {
            return OTHER_PROVIDER;
        }
    }

    private String mapToProduct(BigDecimal productCode) {
        return String.valueOf(productCode);
    }
}
