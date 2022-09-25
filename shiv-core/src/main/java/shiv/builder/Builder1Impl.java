package shiv.builder;

import shiv.provider.Provider1Impl;
import shiv.Module;
import shiv.internal.GraphRepresentation;
import shiv.internal.Provider;

import java.util.List;

public class Builder1Impl<T> implements Module.Builder1<T> {

    final List<Provider<?>> providerList;
    final GraphRepresentation representation;

    final Class<T> in;

    public Builder1Impl(List<Provider<?>> providerList, GraphRepresentation representation, Class<T> in) {
        this.providerList = providerList;
        this.representation = representation;
        this.in = in;
    }

    @Override
    public <A> Module.Builder2<T, A> dependsOn(Class<A> depends) {
        return new Builder2Impl<>(providerList, representation, in, depends);
    }

    @Override
    public void register(Module.ProvidingFunction1<T> func) {
        representation.vertex(in);

        providerList.add(new Provider1Impl<>(in, func));
    }
}
