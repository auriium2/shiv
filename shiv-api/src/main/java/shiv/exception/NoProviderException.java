package shiv.exception;

public class NoProviderException extends ShivInternalException {

    public NoProviderException(String needs) {
        super(
                String.format("[Shiv/Runtime/NoProvider]\n\tError: One of your classes depends on the class %s but none of your registered modules provides a class of that type or supertype! Shiv should have checked this at runtime, if you are seeing this error something has gone terribly wrong!", needs)
        );
    }
}
