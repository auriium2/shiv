package shiv;

import shiv.internal.GraphRepresentation;
import shiv.internal.EmptyGraph;
import shiv.internal.Provider;

public class DefaultProvider implements ShivProvider {
    @Override
    public Shiv provide(Module... modules) {
        DefaultRegistration registration = new DefaultRegistration();

        for (Module module : modules) {
            module.registerSubsystems(registration);
        }


        return new DefaultShiv(registration.export().toArray(Provider[]::new));
    }

    @Override
    public byte priority() {
        return 1;
    }


}
