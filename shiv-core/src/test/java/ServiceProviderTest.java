import org.junit.jupiter.api.Test;
import shiv.Shiv;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceProviderTest {


    @Test
    public void serviceProviderShouldLoad() {
        Shiv shiv = Shiv.provide(a -> {});

        assertEquals("default", shiv.name());
    }

}
