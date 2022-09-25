package shiv.missing;

import org.junit.jupiter.api.Test;
import shiv.Shiv;
import shiv.analyzer.MissingProviderException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MissingDependencyTest {

    @Test
    public void missingDependencyShouldThrow() throws Exception {
        Shiv shiv = Shiv.provide(new MissingDependencyModule());
        Optional<Exception> e = shiv.verify();

        assertTrue(e.isPresent());
        assertThrows(MissingProviderException.class, () -> {
            throw e.get();
        });
    }

}
