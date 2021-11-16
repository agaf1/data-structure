package pl.aga.datastructure.dequeue;

public class Dequeue<T> {

    public Dequeue() {
    }

    private class Node<K> {
        K value;
        Node<K> left;
        Node<K> right;
    }

    private Node<T> leftActual;
    private Node<T> rightActual;
    private int count;

    public void pushLeft(T element) {
        Node<T> node = createNode(element);

        if (leftActual == null) {
            leftActual = node;
            rightActual = node;
        } else {
            node.right = leftActual;
            leftActual.left = node;

            leftActual = node;
        }
        count++;
    }

    public void pushRight(T element) {
        Node<T> node = createNode(element);

        if (rightActual == null) {
            rightActual = node;
            leftActual = node;
        } else {
            node.left = rightActual;
            rightActual.right = node;

            rightActual = node;
        }
        count++;
    }

    public T popLeft() {
        if (leftActual != null) {
            T val = leftActual.value;
            Node<T> helpNode = leftActual.right;
            if (helpNode != null) {
                helpNode.left = null;
                leftActual = helpNode;
            } else {
                leftActual = null;
                rightActual = null;
            }
            count--;
            return val;
        }
        return null;
    }

    public T popRight() {
        if (rightActual != null) {
            T val = rightActual.value;
            Node<T> helpNode = rightActual.left;
            if (helpNode != null) {
                helpNode.right = null;
                rightActual = helpNode;
            } else {
                rightActual = null;
                leftActual = null;
            }
            count--;
            return val;
        }
        return null;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return leftActual == null && rightActual == null;
    }

    private Node<T> createNode(T element) {
        Node<T> node = new Node<>();
        node.value = element;
        node.left = null;
        node.right = null;
        return node;
    }


}
