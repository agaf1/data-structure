package pl.aga.datastructure.stack;

public interface Stack<T> {

    boolean push(T element);

    T pop();

    int size();
}
