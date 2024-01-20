package org.drogo.basics.exception;

public class AgeLessThanZeroException extends Exception {

    public AgeLessThanZeroException(String message){
        super(message);
    }

    public AgeLessThanZeroException() {
    }


    public AgeLessThanZeroException(Throwable cause) {
        super(cause);
    }

    public AgeLessThanZeroException(String message, Throwable cause) {
        super(message, cause);
    }

}
