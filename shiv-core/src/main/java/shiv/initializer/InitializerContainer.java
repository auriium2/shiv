package shiv.initializer;

public sealed interface InitializerContainer permits ContainerOne, ContainerTwo {

    Object produce(Object[] objects);
    Class<?>[] dependencies();
    Class<?> provides();
}
