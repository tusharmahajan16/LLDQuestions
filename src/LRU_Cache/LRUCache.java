package LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    public DoublyLinkedList<K, V> linkedList;
    int capacity;
    Map<K, Node<K, V>> cache;

    LRUCache(int capacity) {
        this.capacity = capacity;
        linkedList = new DoublyLinkedList<>();
        cache = new HashMap<>();
    }

    public synchronized V get(K key) {
        if (!cache.containsKey(key)) {
            System.out.println("Key is not Present");
            return null;
        }
        Node<K, V> node = cache.get(key);
        linkedList.moveToFront(node);
        return node.value;
    }

    public synchronized void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            node.value = value;
            linkedList.moveToFront(node);

        } else {
            if (cache.size() == capacity) {
                Node<K, V> leastRecentlyUsedNode = linkedList.removeLast();
                if (leastRecentlyUsedNode != null) {
                    cache.remove(leastRecentlyUsedNode.key);
                }
            }
            Node<K, V> node = new Node<>(key, value);
            linkedList.addFirst(node);
            cache.put(key, node);
        }
    }

    public synchronized void remove(K key) {
        if (!cache.containsKey(key)) {
            return;
        }
        Node<K, V> node = cache.get(key);
        cache.remove(key);
        linkedList.remove(node);
    }
}
