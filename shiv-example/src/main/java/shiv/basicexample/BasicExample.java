package shiv.basicexample;

import shiv.Shiv;
import shiv.basicexample.deps.*;

public class BasicExample {

    public static void main(String[] args) {

        Shiv test = Shiv.provide(new CoreModule());

        Shiv s = Shiv.provide();

        s.withProvider(Core.class).noDependencies().register(Core::new);
        s.withApplication().dependencies(CoreUser.class).register(user -> 2).calls();


        ShivApp app = test.build();
        SmartCoreUser user = app.get(SmartCoreUser.class);
        user.specialIncrement();
        CoreChecker checker = app.get(CoreChecker.class);
        System.out.println(checker.isCorrect());


    }

}
