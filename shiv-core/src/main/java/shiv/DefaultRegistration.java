package shiv;

import shiv.builder.Builder1Impl;
import shiv.internal.EmptyGraph;
import shiv.internal.GraphRepresentation;
import shiv.internal.Provider;

import java.util.ArrayList;
import java.util.List;

public class DefaultRegistration implements Shiv.Registration {

    final List<Provider<?>> providers = new ArrayList<>();
    final GraphRepresentation empty = new EmptyGraph();

    @Override
    public <T> Module.Builder1<T> provides(Class<T> returnType) {
        return new Builder1Impl<>(providers, empty, returnType);
    }

    List<Provider<?>> export() {
        return providers;
    }
}
