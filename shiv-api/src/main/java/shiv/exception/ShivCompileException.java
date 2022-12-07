package shiv.exception;

public class ShivCompileException extends RuntimeException{

    public ShivCompileException(String message) {
        super(message, null, false, false);
    }

}
