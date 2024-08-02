package ar.com.laboratory.candidatesapi.infrastructure.exceptions;

public class DolarClientException extends RuntimeException{
    private final static String ERROR_MESSAGE = "Dolar client exception. %s";
    public DolarClientException(String ERROR, String message){
        super(String.format(ERROR_MESSAGE, ERROR));
    }
}