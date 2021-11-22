package pl.aga.datastructure.linkedMap;

import java.util.Iterator;

public class LinkedMap<K, V> {

    private static class Pair<K, V> {
        K key;
        V value;
        Pair<K, V> prev;
        Pair<K, V> next;
    }

    private Pair<K, V> current;
    private int count;

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key not be null");
        }
        Pair<K, V> foundedPair = findByKey(key);
        if (value != null) {
            if (foundedPair == null) {
                addNewPair(key, value);
            } else {
                changeValueInExistingPair(foundedPair, value);
            }
        } else {
            removePair(foundedPair);
        }
    }

    public V get(K key) {
        Pair<K, V> foundedPair = findByKey(key);
        return foundedPair == null ? null : foundedPair.value;

    }

    public int size() {
        return count;
    }

    public void delete(K key) {
        Pair<K, V> pair = findByKey(key);
        removePair(pair);
    }

    public boolean contains(K key) {
        Pair<K, V> pair = findByKey(key);
        return pair != null;
    }

    private Pair<K, V> findByKey(K key) {
        Pair<K, V> i = current;
        Pair<K, V> foundedPair = null;
        while (i != null) {
            if (i.key.equals(key)) {
                foundedPair = i;
                break;
            }
            i = i.prev;
        }
        return foundedPair;
    }

    private void addNewPair(K key, V value) {
        Pair<K, V> newPair = createPair(key, value);
        if (current != null) {
            current.next = newPair;
        }
        newPair.prev = current;
        current = newPair;
        count++;
    }

    private void changeValueInExistingPair(Pair<K, V> pair, V value) {
        pair.value = value;
    }

    private void removePair(Pair<K, V> pair2remove) {
        if (pair2remove != null) {
            Pair<K, V> nextPair = pair2remove.next;
            Pair<K, V> prevPair = pair2remove.prev;
            if (nextPair != null) {
                nextPair.prev = prevPair;
            }
            if (prevPair != null) {
                prevPair.next = nextPair;
            }
            count--;
        }
    }

    public Iterator<K> keys() {
        return new LinkedMapIterator<>();
    }

    private class LinkedMapIterator<T extends K> implements Iterator<T> {
        Pair<K, V> actualPair = current;

        @Override
        public boolean hasNext() {
            return actualPair != null;
        }

        @Override
        public T next() {
            T k = (T) actualPair.key;
            actualPair = actualPair.prev;
            return k;
        }
    }

    private Pair<K, V> createPair(K key, V value) {
        Pair<K, V> pair = new Pair<>();
        pair.key = key;
        pair.value = value;
        pair.prev = null;
        pair.next = null;
        return pair;
    }
}
