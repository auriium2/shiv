package shiv;

import shiv.internal.Provider;

import java.util.List;
import java.util.Optional;

public class DefaultShiv implements Shiv {

    final List<Provider<?>> providers;

    public DefaultShiv(List<Provider<?>> providers) {
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
}
