package pl.aga.datastructure.stack;


public class NoBoundedStack<T> implements Stack<T> {

    private class Node<K> {
        K value;
        Node prev;
    }

    private Node current;
    private int count;

    @Override
    public boolean push(T element) {

        Node<T> node = new Node<>();
        node.prev = null;
        node.value = element;

        if (current == null) {
            current = node;
        } else {
            node.prev = current;
            current = node;
        }
        count++;
        return true;
    }

    @Override
    public T pop() {
        if (current != null) {
            T val = (T) current.value;
            Node helpNode = current.prev;
            current = helpNode;
            count--;
            return val;
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
