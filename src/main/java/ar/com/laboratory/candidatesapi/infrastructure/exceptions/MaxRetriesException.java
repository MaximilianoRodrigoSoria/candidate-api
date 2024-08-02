package ar.com.laboratory.candidatesapi.infrastructure.exceptions;

public class MaxRetriesException extends RuntimeException{
    private final static String ERROR_MESSAGE = "Max retries reached for client %s";
    public MaxRetriesException(String tableName){
        super(String.format(ERROR_MESSAGE,tableName));
    }
}