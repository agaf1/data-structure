package pl.aga.datastructure.stack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class UnboundedStack<T> implements Stack<T> {

    UnboundedStack() {
    }

    UnboundedStack(Stack<T> stack) {

        ArrayList<T> copiedValues = new ArrayList<>();
        for (T e : stack) {
            copiedValues.add(e);
        }
        Collections.reverse(copiedValues);
        for (T val : copiedValues) {
            this.push(val);
        }
    }

    private class Node<K> {
        K value;
        Node<K> prev;
    }

    private Node<T> current;
    private int count;

    @Override
    public boolean push(T element) {

        Node<T> node = new Node<>();

        node.value = element;

        node.prev = current;
        current = node;

        count++;
        return true;
    }

    @Override
    public T pop() {
        if (current != null) {
            T val = current.value;
            Node<T> helpNode = current.prev;
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

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>();
    }

    private class StackIterator<K> implements Iterator<K> {

        private UnboundedStack<K>.Node<K> tempNode = (UnboundedStack<K>.Node<K>) current;

        @Override
        public boolean hasNext() {
            return tempNode != null;
        }

        @Override
        public K next() {
            K resultValue = tempNode.value;
            tempNode = tempNode.prev;
            return resultValue;
        }
    }
}
