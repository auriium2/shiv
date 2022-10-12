package shiv;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public interface Application<T> extends Supplier<T> {

    Optional<Exception> test();
    void testThrow();

    List<String> calls();
    T get();

}
