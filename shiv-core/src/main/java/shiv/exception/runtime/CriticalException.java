package shiv.exception.runtime;

import shiv.exception.ShivInternalException;

public class CriticalException extends ShivInternalException {

    final static String error = "[Shiv/Internal/CriticalError]" +
            "\n\tError: Something terrible has gone wrong in the Shiv Dependency Framework" +
            "\n\tCaused by: %s" +
            "\n\nIf you are seeing this error, please report this to the developer of shiv!";

    public CriticalException(String issue) {
        super(String.format(error, issue));
    }
}
