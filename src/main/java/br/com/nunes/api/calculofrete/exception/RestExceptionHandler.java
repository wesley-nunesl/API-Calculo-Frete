package br.com.nunes.api.calculofrete.exception;

import br.com.nunes.api.calculofrete.service.exceptions.CepNotFoundException;
import br.com.nunes.api.calculofrete.service.exceptions.FreteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.w3c.dom.events.EventException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FreteNotFoundException.class)
    private ResponseEntity<String> freteNotFoundHandler(FreteNotFoundException exception){
        RestErrorMessage restErrorMessage = new RestErrorMessage();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao calcular o frete");
    }

    @ExceptionHandler(CepNotFoundException.class)
    private ResponseEntity<String> cepNotFoundHandler(FreteNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao buscar o frete");
    }
}
