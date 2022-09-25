package shiv.recursive;

import org.junit.jupiter.api.Test;
import shiv.Shiv;
import shiv.analyzer.RecursiveDependencyException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class RecursiveDependencyTest {

    @Test
    public void noRecursionShouldNotThrow() {
        Shiv shiv = Shiv.provide(new OkRecursiveModule());

        assertFalse(shiv.verify().isPresent());
    }

    @Test
    public void recursiveDepShouldThrow() {
        Shiv shiv = Shiv.provide(new EvilRecursiveModule());
        Optional<Exception> exception = shiv.verify();

        assertTrue(exception.isPresent());
        assertThrows(RecursiveDependencyException.class, () -> {
            throw exception.get();
        });
    }

    @Test
    public void selfDepShouldThrow() throws Exception {
        Shiv shiv = Shiv.provide(new SelfDependencyModule());
        Optional<Exception> e = shiv.verify();

        assertTrue(e.isPresent());
        assertThrows(RecursiveDependencyException.class, () -> {
            throw e.get();
        });
    }

}
