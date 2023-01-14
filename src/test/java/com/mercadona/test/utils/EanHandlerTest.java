package com.mercadona.test.utils;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;
import com.mercadona.test.utils.exceptions.CauseException;
import com.mercadona.test.utils.mapper.EanMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EanHandlerTest {

    @Test
    public void introduceEANWithoutErrors_Mercadona() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("8437008459059");

        //when
        EanResponse result = eanHandler.toDomain(eanTest);

        //then
        assertEquals(EanMapper.HACENDADO, result.getProvider());
        assertEquals("45905", result.getProductCode());
        assertEquals(EanMapper.MERCADONA_OFICINA, result.getAddress());
    }

    @Test
    public void introduceEANWithoutErrors() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("8480000160072");

        //when
        EanResponse result = eanHandler.toDomain(eanTest);

        //then
        assertEquals(EanMapper.OTHER_PROVIDER, result.getProvider());
        assertEquals("16007", result.getProductCode());
        assertEquals(EanMapper.MERCADONA_SPAIN, result.getAddress());
    }

    @Test
    public void introduceEANWithoutErrors_Portugal() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("8480000160076");

        //when
        EanResponse result = eanHandler.toDomain(eanTest);

        //then
        assertEquals(EanMapper.OTHER_PROVIDER, result.getProvider());
        assertEquals("16007", result.getProductCode());
        assertEquals(EanMapper.MERCADONA_PORTUGAL, result.getAddress());
    }

    @Test
    public void introduceEANWithoutErrors_Almacenes() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("8480000160078");

        //when
        EanResponse result = eanHandler.toDomain(eanTest);

        //then
        assertEquals(EanMapper.OTHER_PROVIDER, result.getProvider());
        assertEquals("16007", result.getProductCode());
        assertEquals(EanMapper.ALMACEN, result.getAddress());
    }

    @Test
    public void introduceEANWithoutErrors_Colmenas() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("8480000160070");

        //when
        EanResponse result = eanHandler.toDomain(eanTest);

        //then
        assertEquals(EanMapper.OTHER_PROVIDER, result.getProvider());
        assertEquals("16007", result.getProductCode());
        assertEquals(EanMapper.COLMENAS, result.getAddress());
    }

    @Test
    public void introduceEANWithCharacters() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("84370XX459059");

        //when
        CauseException thrown = Assertions.assertThrows(CauseException.class, () -> {
            eanHandler.toDomain(eanTest);
        });

        //then
        Assertions.assertEquals("EAN composition not valid. Should be only numbers.", thrown.getMessage());
    }

    @Test
    public void introduceEANWithWrongLength() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("843759059");

        //when
        CauseException thrown = Assertions.assertThrows(CauseException.class, () -> {
            eanHandler.toDomain(eanTest);
        });

        //then
        Assertions.assertEquals("EAN lenght not valid. Should be exactly 13 characters.", thrown.getMessage());
    }

    @Test
    public void introduceEANWithWrongDestiny() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("8437008459057");

        //when
        CauseException thrown = Assertions.assertThrows(CauseException.class, () -> {
            eanHandler.toDomain(eanTest);
        });

        //then
        Assertions.assertEquals("The final destiny not should be 7.", thrown.getMessage());
    }
}