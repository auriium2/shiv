package shiv.basicexample.deps;

public class SmartCoreUser {

    final Core core;
    final CoreUser user;

    public SmartCoreUser(Core core, CoreUser user) {
        this.core = core;
        this.user = user;
    }

    public void specialIncrement() {
        user.use();
        core.coreFunctionB();
    }
}
