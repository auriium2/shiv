package shiv.provider;

import shiv.Module;
import shiv.internal.Provider;

public class Provider1Impl<T> implements Provider<T> {

    final Class<T> provides;
    final Module.ProvidingFunction1<T> contextlessFunction;

    public Provider1Impl(Class<T> provides, Module.ProvidingFunction1<T> contextlessFunction) {
        this.provides = provides;
        this.contextlessFunction = contextlessFunction;
    }

    @Override
    public T provide(Provider.Function provideFunction) {
        return contextlessFunction.provide(); //TODO cache the singleton!!!!
    }

    @Override
    public Class<?> mostSpecificProvides() {
        return provides;
    }
}
