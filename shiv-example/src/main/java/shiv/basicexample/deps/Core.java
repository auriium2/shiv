package shiv.basicexample.deps;

public class Core {

    int a = 0;

    int coreFunctionA() {
        a++;

        return 1;
    }

    int coreFunctionB() {
        a++;

        return 7;
    }

    int coreCounter() {
        return a;
    }

}
