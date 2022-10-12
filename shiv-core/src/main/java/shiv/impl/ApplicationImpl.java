package shiv.impl;

import shiv.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApplicationImpl<T> implements Application<T> {

    //we need a map of stuff here

    final List<Connector> connectors = new ArrayList<>();


    @Override
    public Optional<Exception> test() {
        return Optional.empty();
    }

    @Override
    public List<String> calls() {
        return null;

    }

    @Override
    public T get() {

        //we need to call the map of stuff here

        return null;
    }
}
