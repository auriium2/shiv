package shiv;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import shiv.basicexample.deps.CoreModule;
import shiv.basicexample.deps.SmartCoreUser;

public class SillyBenchmark {


    static final Injector injector = Guice.createInjector(new GoogleVersionOfCoreModule());
    static final ShivApp shiv = Shiv.provide(new CoreModule()).build();

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void googleTurn(Blackhole blackhole) {
        injector.getInstance(SmartCoreUser.class).specialIncrement();
    }

    @Benchmark
    @Fork(value = 1, warmups = 0)
    @BenchmarkMode(Mode.Throughput)
    public void myTurn(Blackhole blackhole) {
        shiv.get(SmartCoreUser.class).specialIncrement();
    }

}
