package br.com.nunes.api.calculofrete.service.exceptions;

public class FreteNotFoundException extends RuntimeException{
    public FreteNotFoundException(String message){
        super(message);
    }
}
