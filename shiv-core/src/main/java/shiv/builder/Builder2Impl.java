package shiv.builder;

import shiv.provider.Provider2Impl;
import shiv.Module;
import shiv.internal.GraphRepresentation;
import shiv.internal.Provider;

import java.util.List;

public class Builder2Impl<T,A> implements Module.Builder2<T,A> {

    final List<Provider<?>> providerList;
    final GraphRepresentation representation;

    final Class<T> in;
    final Class<A> a;

    public Builder2Impl(List<Provider<?>> providerList, GraphRepresentation representation, Class<T> in, Class<A> a) {
        this.providerList = providerList;
        this.representation = representation;
        this.in = in;
        this.a = a;
    }

    @Override
    public <B> Module.Builder3<T, A, B> dependsOn(Class<B> depends) {
        return new Builder3Impl<>(providerList, representation, in, a, depends);
    }

    @Override
    public void register(Module.ProvidingFunction2<T, A> func) {
        representation.vertex(in);
        representation.edge(in, a);

        providerList.add(new Provider2Impl<>(func, in, a));
    }
}
