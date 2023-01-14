package com.mercadona.test.utils;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;
import com.mercadona.test.utils.mapper.EanMapper;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EanHandlerTest {

    @Test
    public void introduceEANWithoutErrors() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("8437008459059");

        //when
        EanResponse result = eanHandler.toDomain(eanTest);

        //then
        assertEquals("Hacendado", result.getProvider());
        assertEquals("45905", result.getProductCode());
        assertEquals(EanMapper.MERCADONA_OFICINA, result.getAddress());
    }

    @Test
    public void introduceEANWithCharacters() {
        //given
        EanHandler eanHandler = new EanHandler();
        Ean eanTest = new Ean("84370XX459059");

        //when
        EanResponse result = eanHandler.toDomain(eanTest);

        //then
        assertEquals("Hacendado", result.getProvider());
        assertEquals("45905", result.getProductCode());
        assertEquals(EanMapper.MERCADONA_OFICINA, result.getAddress());
    }
}