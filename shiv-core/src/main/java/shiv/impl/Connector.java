package shiv.impl;

import java.util.function.Function;

//i love java it is so fun
public class Connector {

    final Class<?> provides;
    final Class<?>[] requires;
    final Function<Object[],Object> supplier;

    public Connector(Class<?> provides, Class<?>[] requires, Function<Object[], Object> supplier) {
        this.provides = provides;
        this.requires = requires;
        this.supplier = supplier;
    }
}
