package shiv;

import shiv.flexible.ISelector;

import java.util.function.BiFunction;

public interface Dependencies {

    <A,B,C> C with(ISelector<A> a, ISelector<B> b, BiFunction<A,B,C> bifunction);

}
