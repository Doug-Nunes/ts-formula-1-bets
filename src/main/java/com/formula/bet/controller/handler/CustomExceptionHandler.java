package com.formula.bet.controller.handler;

import com.formula.bet.dto.DetailedResponseDTO;
import com.formula.bet.exception.InsufficientBalanceException;
import com.formula.bet.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(NotFoundException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new DetailedResponseDTO(
                        "Not Found",
                        ex.getMessage(),
                        "404"
                ));
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    protected ResponseEntity<Object> handleInsufficientBalanceException(InsufficientBalanceException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new DetailedResponseDTO(
                        "Issuficient Balance",
                        ex.getMessage(),
                        "400"
                ));
    }


    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new DetailedResponseDTO(
                        "Internal Server Error",
                        ex.getMessage(),
                        "500"
                ));
    }
}
