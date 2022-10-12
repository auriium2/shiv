package shiv.analyzer;

import shiv.checker.ShivAnalyzeException;

public class RecursiveDependencyException extends ShivAnalyzeException {



    public RecursiveDependencyException(String str) {
        super(
                str,
                null,
                false,
                false
        );
    }
}
