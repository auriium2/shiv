package shiv.internal;

public class CachedProvider<T> implements Provider<T> {

    T t;

    final Provider<T> delegate;

    public CachedProvider(Provider<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T provide(Function provider) {
        if (t == null) {
            t = delegate.provide(provider);
        }

        return t;
    }

    @Override
    public Class<?> mostSpecificProvides() {
        return delegate.mostSpecificProvides();
    }
}
