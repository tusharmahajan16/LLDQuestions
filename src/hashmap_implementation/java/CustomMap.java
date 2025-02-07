package hashmap_implementation.java;

import java.util.ArrayList;
import java.util.List;

public class CustomMap<K, V> {

    static class MapNode<K, V> {
        K key;
        V value;
        MapNode<K, V> next;

        MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity;
    List<MapNode<K, V>> bucket; // contains head of all chains
    int INITIAL_CAPACITY = 16;
    double LOAD_FACTOR = 0.75;

    CustomMap() {
        bucket = new ArrayList<>();
        size = 0;
        capacity = INITIAL_CAPACITY;
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
    }

    // getIndex Method

    public int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    //put Method
    public void put(K key, V value) {
        int index = getIndex(key);
        MapNode<K, V> head = bucket.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        MapNode<K, V> newNode = new MapNode<>(key, value);
        head = bucket.get(index);
        newNode.next = head;
        bucket.set(index, newNode);
        size++;
        double currentLoadFactor = (1.0 * size) / capacity;
        System.out.println("Inserting Key: " + key);
        System.out.println("LoadFactor: " + currentLoadFactor);
        if (currentLoadFactor > LOAD_FACTOR) {
            rehash();
        }
    }

    private void rehash() {
        System.out.println("Rehashing...");
        List<MapNode<K, V>> temp = bucket;
        bucket = new ArrayList<>();
        capacity = capacity * 2;
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
        size = 0;
        for (MapNode<K, V> node : temp) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    // get method
    public V get(K key) {
        int index = getIndex(key);
        MapNode<K, V> head = bucket.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    //remove method
    public void remove(K key) {
        int index = getIndex(key);
        MapNode<K, V> head = bucket.get(index);
        MapNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    bucket.set(index, head.next);
                } else {
                    prev.next = head.next;
                }
                head.next = null;
                size--;
                break;
            }
            prev = head;
            head = head.next;
        }
    }
}
