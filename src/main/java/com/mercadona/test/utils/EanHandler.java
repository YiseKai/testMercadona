package com.mercadona.test.utils;

import com.mercadona.test.model.Ean;
import com.mercadona.test.model.EanResponse;
import com.mercadona.test.utils.exceptions.CauseException;
import com.mercadona.test.utils.mapper.EanMapper;

import java.math.BigDecimal;

public class EanHandler {

    public Ean ean;

    public EanResponse toDomain(Ean ean) {
        validateEanNumber(ean);
        return new EanMapper().mapToEanResponse(splitProvider(),splitProductCode(), splitAddress());
    }

    private void validateEanNumber(Ean ean) {
        this.ean = ean;
        checkLenght();
        checkOnlyNumbers();
        checkDestiny();
    }

    private void checkDestiny() throws CauseException {
        if(isValidDestiny()) {
            throw new CauseException("The final destiny not should be 7.");
        }
    }

    private void checkOnlyNumbers() throws CauseException {
        if(!onlyNumbers()){
            throw new CauseException("EAN composition not valid. Should be only numbers.");
        }
    }

    private void checkLenght() throws CauseException {
        if(!validLength()){
            throw new CauseException("EAN lenght not valid. Should be exactly 13 characters.");
        }
    }

    private boolean isValidDestiny() {
        return ean.getEanNumber().equals("7");
    }

    private boolean onlyNumbers() {
        return ean.getEanNumber().matches("[0-9]+");
    }

    private boolean validLength() {
        return ean.getEanNumber().length() == 13;
    }

    private String splitProvider() {
        return ean.getEanNumber().substring(0, 7);
    }

    private String splitProductCode() {
        return ean.getEanNumber().substring(7, 12);
    }

    private String splitAddress() {
        return ean.getEanNumber().substring(12);
    }
}
