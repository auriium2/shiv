package shiv.internal;

public interface InternalProvider<T> {

    interface Function {
        <T> T generate(Class<T> clazz);
    }

    interface CheckedFunction {
        //where id is the root id of the object request
        <T> T generate(int id, Class<?> requester, Class<T> desired); //will throw exception if r-d is seen twice in the queue
    }

    //TODO checked generate - is this overhead?

    T provide(Function provider);
    Class<?> mostSpecificProvides();

}
