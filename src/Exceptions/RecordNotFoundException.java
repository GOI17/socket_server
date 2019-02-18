package Exceptions;

public class RecordNotFoundException extends Exception{
    //attributes
    private String message;
    
    //getter
    @Override
    public String getMessage() {
        return this.message;
    }
    
    public RecordNotFoundException() {
        this.message = "Record not found";
    }
    
    public RecordNotFoundException(Object id) {
        this.message = "Record not found for id " + id.toString();
    }
}
