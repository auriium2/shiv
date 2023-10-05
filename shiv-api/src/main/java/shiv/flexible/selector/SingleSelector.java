package shiv.flexible.selector;

import shiv.exception.ShivInternalException;
import shiv.flexible.ISelector;

import java.nio.IntBuffer;

public class SingleSelector<T> implements ISelector<T> {

    final Class<T> desired;

    public SingleSelector(Class<T> desired) {
        this.desired = desired;
    }

    @Override
    public boolean[] select(Outputs[] provideds) throws ShivInternalException {

        boolean detectedYet = false;
        boolean[] bools = new boolean[provideds.length];

        for (int i = 0; i < provideds.length; i++) {
            if (provideds[i].provides.isAssignableFrom(desired)) {
                if (detectedYet) throw new ShivInternalException("what");

                bools[i] = true;

                detectedYet = true;
            } else {
                bools[i] = false;
            }
        }

        return bools;

    }

    @Override
    public T provides(Object[] ob) {
        return desired.cast(ob[0]);
    }
}
