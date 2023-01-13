package com.mercadona.test.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface EanAPI {

    @GetMapping(value = "/getInfo")
    default void getInfo() {

    }
}