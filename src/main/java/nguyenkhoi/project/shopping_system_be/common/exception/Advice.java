/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.exception;

import nguyenkhoi.project.shopping_system_be.common.util.Constant;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(1)
@RestControllerAdvice
public class Advice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse errorResponse1() {
        return ErrorResponse.builder()
                            .message(Constant.msgError)
                            .build();
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorResponse errorResponse2() {
        return ErrorResponse.builder()
                            .message(Constant.msgError)
                            .build();
    }
}
