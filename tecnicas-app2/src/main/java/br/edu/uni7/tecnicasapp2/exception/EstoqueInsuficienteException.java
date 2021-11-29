package br.edu.uni7.tecnicasapp2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EstoqueInsuficienteException extends RuntimeException {
}
