package com.example.mysqltest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@Getter
public class ApplicationException extends RuntimeException {
    private int code;
    private String message;
}
