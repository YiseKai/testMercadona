package com.mercadona.test.utils.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CauseException extends RuntimeException{

    private String detail;

    public CauseException(String cause) {
        super(cause);
        this.detail = cause;
    }
}
