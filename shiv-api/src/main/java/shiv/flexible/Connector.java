package shiv.flexible;

import java.util.function.Function;

public class Connector {

    public final ISelector<?>[] requires;
    public final Class<?> provides;
    public final Class<?>[] typed;
    public final Function<Object[],Object> supplier;

    public Connector(ISelector<?>[] requires, Class<?> provides, Class<?>[] typed, Function<Object[], Object> supplier) {
        this.requires = requires;
        this.provides = provides;
        this.typed = typed;
        this.supplier = supplier;
    }
}
