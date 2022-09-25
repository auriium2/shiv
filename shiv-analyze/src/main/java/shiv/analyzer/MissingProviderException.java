package shiv.analyzer;

import shiv.AnalyticGraph;
import shiv.checker.ShivCompileException;

import java.util.Set;

public class MissingProviderException extends ShivCompileException {

    public MissingProviderException(String message) {

        super(
              message,
              null,
              false,
              false
        );
    }
}
