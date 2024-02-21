package br.com.mrocha.desafio6.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class TratadorExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity tratarErroDaValidacao(IllegalArgumentException e) {

        return ResponseEntity.badRequest().body(new DadosErro400(LocalDateTime.now(), e.getMessage()));

    }

    private record DadosErro400(LocalDateTime timestamp, String message) {


    }
}
