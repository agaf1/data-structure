package pl.aga.datastructure.stack;

public interface Stack<T> extends Iterable<T> {

    boolean push(T element);

    T pop();

    int size();
}
