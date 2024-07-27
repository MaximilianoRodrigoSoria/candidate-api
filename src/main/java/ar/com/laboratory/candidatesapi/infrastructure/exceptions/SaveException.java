package ar.com.laboratory.candidatesapi.infrastructure.exceptions;

public class SaveException extends RuntimeException{
    private final static String ERROR_MESSAGE = "Record saving in %s";
    public SaveException(String tableName){
        super(String.format(ERROR_MESSAGE,tableName));
    }
}