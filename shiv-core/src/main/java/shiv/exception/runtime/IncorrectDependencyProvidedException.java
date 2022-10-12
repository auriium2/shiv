package shiv.exception.runtime;

import shiv.checker.ShivInternalException;

import java.util.Arrays;

public class IncorrectDependencyProvidedException extends ShivInternalException {

    final static String error = "[Shiv/Runtime/IncorrectDependencyProvided]" +
            "\n\tError: The provider [%s] (providing class [%s]) depends on the following classes: [%s]" +
            "\n\tHowever, when it asked the provider [%s] (providing class [%s]) it instead got class: [%s]" +
            "\n\nThis should have been caught at compile time by shiv. Please report this bug to the author.";

    public IncorrectDependencyProvidedException(String provider, Class<?> providerClass, Class<?>[] classes, String badProvider, Class<?> badProviderClass, Class<?> badProvidedObject) {
        super(
                String.format(error, provider, providerClass, Arrays.toString(classes), badProvider, badProviderClass, badProvidedObject)
        );
    }
}
