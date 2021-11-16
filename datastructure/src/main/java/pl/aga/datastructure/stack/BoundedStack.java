package pl.aga.datastructure.stack;

import java.lang.reflect.Array;
import java.util.Iterator;

public class BoundedStack<T> implements Stack<T> {

    private final T[] elements;
    private int i;

    public BoundedStack(Class<T> clazz, int capacity) {
        elements = (T[]) Array.newInstance(clazz, capacity);
    }

    public boolean push(T element) {
        boolean result = false;
        if (i < elements.length) {
            elements[i++] = element;
            result = true;
        }
        return result;
    }

    public T pop() {
        if (i > 0) {
            i--;
            T res = elements[i];
            elements[i] = null;
            return res;
        }
        return null;
    }

    public int size() {
        return i;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIter<>();
    }


    private class StackIter<T1 extends T> implements Iterator<T1> {
        private int iteratorIdx = elements.length;

        @Override
        public boolean hasNext() {
            return iteratorIdx > 0;
        }

        @Override
        public T1 next() {
            return (T1) elements[--iteratorIdx];
        }
    }

}
