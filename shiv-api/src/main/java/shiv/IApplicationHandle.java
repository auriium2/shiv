package shiv;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public interface IApplicationHandle<T> {

    Optional<Exception> test();
    void testThrow();

    List<String> calls();
    T get();

}
