package com.mercadona.test.utils.mapper;

import com.mercadona.test.model.EanResponse;

import java.math.BigDecimal;

public class EanMapper {

    public static final String MERCADONA_SPAIN = "Tiendas Mercadona España";
    public static final String MERCADONA_PORTUGAL = "Tiendas Mercadona Portugal";
    public static final String ALMACEN = "Almacenes";
    public static final String MERCADONA_OFICINA = "Oficinas Mercadona";
    public static final String COLMENAS = "Colmenas";
    public static final String MERCADONA_PROVIDER = "8437008";
    public static final String HACENDADO = "Hacendado";
    public static final String OTHER_PROVIDER = "Otro proveedor";

    public EanResponse mapToEanResponse(String provider, String product, String address) {
        return new EanResponse(mapToProvider(provider), product, mapToDestiny(address));
    }

    private String mapToDestiny(String address) {
        String result = "";
        switch (address) {
            case "1": case "2": case "3": case "4": case "5": result = MERCADONA_SPAIN; break;
            case "6": result = MERCADONA_PORTUGAL; break;
            case "8": result = ALMACEN; break;
            case "9": result = MERCADONA_OFICINA; break;
            case "0": result = COLMENAS; break;
        }
        return result;
    }

    private String mapToProvider(String provider) {
        if(provider.equals(MERCADONA_PROVIDER)) {
            return HACENDADO;
        } else {
            return OTHER_PROVIDER;
        }
    }
}
