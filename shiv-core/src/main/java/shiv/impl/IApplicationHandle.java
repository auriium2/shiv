package shiv.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IApplicationHandle<T> implements shiv.IApplicationHandle<T> {



    @Override
    public Optional<Exception> test() {
        return Optional.empty();
    }

    @Override
    public void testThrow() {

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
