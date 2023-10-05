package shiv.exception.runtime;

import shiv.exception.ShivInternalException;

import java.util.Arrays;

public class CalledWithoutDependenciesException extends ShivInternalException {

    final static String error = """
            [Shiv/Internal/CalledWithoutDependencies]
            \tError: the provider [%s] (providing [%s]) depends on [%s]
            \tHowever, it was called by shiv with only the dependencies [%s]

            This is an internal error and should be reported.""";

    public CalledWithoutDependenciesException(String provider, Class<?> dependency, Class<?>[] dependencies, Class<?>[] actual) {
        super(String.format(error, provider, dependency, Arrays.toString(dependencies), Arrays.toString(actual)));
    }
}
