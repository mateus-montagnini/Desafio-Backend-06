package br.com.mrocha.desafio6.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity tratarErroDaValidacao(IllegalArgumentException e) {

        return ResponseEntity.badRequest().body(e.getMessage());

    }
}
