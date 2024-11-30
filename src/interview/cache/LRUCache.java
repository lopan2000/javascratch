package interview.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> extends AbstractCache<T> {

    public LRUCache(int capacity) {
        super(capacity);
    }

    public T get(int key) {
        if (map.containsKey(key)) {
            Node<T> node = map.get(key);
            moveToHead(node); //promote to head
            return node.val;
        } else {
            return null;
        }
    }

    public void put(int key, T val) {
        if (map.containsKey(key)) {
            Node<T> node = map.get(key);
            node.val = val;     //update val
            moveToHead(node);   //promote to head
        } else {
            Node<T> node = new Node<T>(key, val);
            map.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                Node<T> removedNode = removeTail();
                map.remove(removedNode.key);
                size--;
            }
        }
    }
}