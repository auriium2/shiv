package shiv;

import java.util.Comparator;
import java.util.Optional;
import java.util.ServiceLoader;

public interface Shiv {

    interface Registration {
        <T> Module.Builder1<T> provides(Class<T> returnType);
    }

    ShivApp build();
    Optional<Exception> verify();
    String name();

    static Shiv provide(Module... modules) {
        ServiceLoader<ShivProvider> loader = ServiceLoader.load(ShivProvider.class);

        Optional<ShivProvider> provider = loader
                .stream()
                .map(ServiceLoader.Provider::get)
                .max(Comparator.comparing(ShivProvider::priority));

        if (provider.isEmpty()) throw new IllegalStateException("Provider isn't present! Something horrible has gone wrong");

        return provider.get().provide(modules);
    }


}
