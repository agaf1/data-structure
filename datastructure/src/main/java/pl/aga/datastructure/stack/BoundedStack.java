package pl.aga.datastructure.stack;

import java.lang.reflect.Array;

public class BoundedStack<T> implements Stack<T> {

    private T[] elements;
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
}
