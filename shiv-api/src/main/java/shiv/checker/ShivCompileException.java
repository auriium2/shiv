package shiv.checker;

//Should only be thrown at compile time...
public class ShivCompileException extends Exception {

    public ShivCompileException() {
    }

    public ShivCompileException(String message) {
        super(message);
    }

    public ShivCompileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShivCompileException(Throwable cause) {
        super(cause);
    }

    public ShivCompileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
