package shiv.analyzer;

import shiv.checker.ShivAnalyzeException;

public class MissingProviderException extends ShivAnalyzeException {

    public MissingProviderException(String message) {

        super(
              message,
              null,
              false,
              false
        );
    }
}
