package shiv;

import shiv.internal.Provider;

import java.util.List;
import java.util.Optional;

public class DefaultShiv implements Shiv {

    final Provider<?>[] providers;

    public DefaultShiv(Provider<?>[] providers) {
        this.providers = providers;
    }

    @Override
    public ShivApp build() {
        return new ShivAppImpl(providers);
    }

    @Override
    public Optional<Exception> verify() {
        //TODO very basic checks
        throw new UnsupportedOperationException("DefaultShiv cannot be verified!");
    }

    @Override
    public String name() {
        return "default";
    }

    @Override
    public <T> T rawAccess(Class<T> clazz) {
        if (clazz == List.class) {
            return (T) providers;
        }

        throw new UnsupportedOperationException("not present");
    }
}
