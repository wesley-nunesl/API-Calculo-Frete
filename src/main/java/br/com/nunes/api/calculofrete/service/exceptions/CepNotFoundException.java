package br.com.nunes.api.calculofrete.service.exceptions;

public class CepNotFoundException extends RuntimeException{
    public CepNotFoundException(String message){
        super(message);
    }
}
