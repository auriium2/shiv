package shiv;

import shiv.internal.ShivProvider;

import java.util.Comparator;
import java.util.Optional;
import java.util.ServiceLoader;


public interface Shiv {

    <T> IProvides<T> withProvider(Class<T> t);
    <T> IProvidesApp<T> withApplication();

    static Shiv provide() {
        ServiceLoader<ShivProvider> loader = ServiceLoader.load(ShivProvider.class);

        Optional<ShivProvider> provider = loader
                .stream()
                .map(ServiceLoader.Provider::get)
                .max(Comparator.comparing(ShivProvider::priority));

        if (provider.isEmpty()) throw new IllegalStateException("Provider isn't present! Something horrible has gone wrong");

        return provider.get().provide();

    }


}
