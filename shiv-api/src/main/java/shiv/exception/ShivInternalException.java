package shiv.exception;

public class ShivInternalException extends Exception {

    public ShivInternalException(String message) {
        super(message, null, false, false);
    }

    public ShivInternalException(String message, boolean critical) {
        super(message, null, false, true);
    }
}
