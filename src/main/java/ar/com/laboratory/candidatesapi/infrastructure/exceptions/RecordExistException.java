package ar.com.laboratory.candidatesapi.infrastructure.exceptions;

public class RecordExistException extends RuntimeException{
    private final static String ERROR_MESSAGE = "Record exist in %s";
    public RecordExistException(String tableName){
        super(String.format(ERROR_MESSAGE,tableName));
    }
}