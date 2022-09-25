package shiv;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ShivApp {

    <T> List<T> getOfType(Class<T> clazz);
    <T> T get(Class<T> clazz);


}
