package shiv;

import org.junit.jupiter.api.Test;
import shiv.Shiv;
import shiv.basicexample.deps.CoreModule;

import java.util.Optional;

public class ShivCompileCheckerTest {

    @Test
    public void testProjectShouldNotThrowExceptions() throws Exception {
        Shiv shiv = Shiv.provide(new CoreModule());
        Optional<Exception> exception = shiv.verify();

        if (exception.isPresent()) {
            throw exception.get();
        }
    }

}
