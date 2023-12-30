package shiv.basicexample.deps;

import jakarta.inject.Inject;

public class SmartCoreUser {

    @Inject
    Core core;
    @Inject
    CoreUser user;

    @Inject
    public SmartCoreUser(Core core, CoreUser user) {
        this.core = core;
        this.user = user;
    }

    public void specialIncrement() {
        user.use();
        core.coreFunctionB();
    }
}
