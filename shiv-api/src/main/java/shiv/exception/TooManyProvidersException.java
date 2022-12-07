package shiv.exception;

public class TooManyProvidersException extends ShivInternalException {

    public TooManyProvidersException(String provider) {
        super(
                String.format("[Shiv/Runtime/TooManyProviders]\n\tError: One of your classes depends on the class %s, but more than one function is registered that provides this class or supertype. Shiv should have checked this at runtime, if you are seeing this error something has gone terribly wrong", provider)
        );
    }

}
