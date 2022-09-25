package shiv;

import shiv.internal.Provider;
import shiv.runtime.NoProviderException;
import shiv.runtime.TooManyProvidersException;

import java.util.*;

public class ShivAppImpl implements ShivApp {

    final List<Provider<?>> providers;

    public ShivAppImpl(List<Provider<?>> providers) {
        this.providers = providers;
    }


    @Override
    public <T> List<T> getOfType(Class<T> clazz) {
        return internalGetListOfType(clazz).stream().map(provider -> provider.provide(this::internalGet)).toList();
    }

    @Override
    public <T> T get(Class<T> clazz) {
        return internalGet(clazz);
    }


    <T> T internalGet(Class<T> type) {
        return internalGetProvider(type).provide(this::internalGet);
    }

    <T> Provider<T> internalGetProvider(Class<T> type) {
        List<Provider<T>> list = internalGetListOfType(type);

        if (list.size() == 0) {
            throw new NoProviderException(type.getSimpleName());
        }

        if (list.size() > 1) {
            throw new TooManyProvidersException(type.getSimpleName());
        }

        return Objects.requireNonNull(list.get(0));
    }

    @SuppressWarnings("unchecked")
    <T> List<Provider<T>> internalGetListOfType(Class<T> type) {
        List<Provider<T>> collected = new ArrayList<>();

        for (Provider<?> provider : providers) {
            if (type.isAssignableFrom(provider.getClass())) {
                collected.add((Provider<T>) provider);
            }
        }

        return collected;
    }



}
