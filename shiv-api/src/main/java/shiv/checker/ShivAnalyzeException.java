package shiv.checker;

//Should only be thrown at compile time...
public class ShivAnalyzeException extends Exception {

    public ShivAnalyzeException(String message) {
        super(message, null, false, false);
    }


}
