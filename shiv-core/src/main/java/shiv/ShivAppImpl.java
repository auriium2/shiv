package shiv;

import shiv.internal.Provider;
import shiv.runtime.TooManyProvidersException;

import java.util.*;

public class ShivAppImpl implements ShivApp {

    final Provider<?>[] providers;

    public ShivAppImpl(Provider<?>[] providers) {
        this.providers = providers;
    }

    final Map<Class<?>, Provider<?>> EYESEAU_CACHE = new HashMap<>();


    @Override
    public <T> List<T> getOfType(Class<T> clazz) {
        return internalGetListOfType(clazz).stream().map(provider -> provider.provide(this::internalGet)).toList();
    }

    @Override
    public <T> T get(Class<T> clazz) {
        return internalGetProvider(clazz).provide(this::internalGet);
    }


    <T> T internalGet(Class<T> type) {
        return internalGetProvider(type).provide(this::internalGet);
    }

    <T> Provider<T> internalGetProvider(Class<T> type) {
        Provider<?> possibleProvider = EYESEAU_CACHE.get(type);
        if (possibleProvider != null) return (Provider<T>) possibleProvider;

        List<Provider<T>> list = internalGetListOfType(type);

        if (list.size() == 0) {
            throw new IllegalStateException(type.getSimpleName());
        }

        if (list.size() > 1) {
            throw new TooManyProvidersException(type.getSimpleName());
        }

        Provider<T> correctProvider = list.get(0);
        EYESEAU_CACHE.put(type, correctProvider);
        return Objects.requireNonNull(correctProvider);
    }

    @SuppressWarnings("unchecked")
    <T> List<Provider<T>> internalGetListOfType(Class<T> type) {
        List<Provider<T>> collected = new ArrayList<>();

        for (Provider<?> provider : providers) {
            if (type.isAssignableFrom(provider.mostSpecificProvides())) {
                collected.add((Provider<T>) provider);
            }
        }

        return collected;
    }



}
