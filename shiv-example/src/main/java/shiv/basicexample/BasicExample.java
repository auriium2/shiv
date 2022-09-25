package shiv.basicexample;

import shiv.Shiv;
import shiv.ShivApp;
import shiv.basicexample.deps.CoreChecker;
import shiv.basicexample.deps.CoreModule;
import shiv.basicexample.deps.SmartCoreUser;

public class BasicExample {

    public static void main(String[] args) {

        Shiv test = Shiv.provide(new CoreModule());

        test.verify();; //should return a verifyResult<Exception> instead of throwing exceptions

        ShivApp app = test.build();
        SmartCoreUser user = app.get(SmartCoreUser.class);
        user.specialIncrement();
        CoreChecker checker = app.get(CoreChecker.class);
        System.out.println(checker.isCorrect());


    }

}
