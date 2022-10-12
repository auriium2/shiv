package shiv.exception;

import shiv.checker.ShivCompileException;

public class DuplicateApplicationException extends ShivCompileException {

    final static String error = """
            [Shiv/Compile/DuplicateApplication]
            \tError: Your code tried to create an application using the method withApplication twice
            \tHowever, withApplication can only be called once as it is used to compile all the dependencies into a single supplier function!

            Remove one call to withApplication or create a separate Shiv instance for the second application!""";

    public DuplicateApplicationException() {
        super(error);
    }
}
