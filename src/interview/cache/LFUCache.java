package interview.cache;

import java.util.*;

/**
 * Need to keep our internal linked list in desc freq order.
 */
public class LFUCache<T> {

    private Map<Integer, HeapNode<T>> map = new HashMap<>();

    private PriorityQueue<HeapNode<T>> minHeap =
            new PriorityQueue<>((x,y) -> Integer.compare(x.freq, y.freq));

    private int capacity, size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public T get(int key) {
        if (map.containsKey(key)) {
            HeapNode<T> node = updateNode(key);
            return node.val;
        } else {
            return null;
        }
    }

    public void put(int key, T val) {
        if (map.containsKey(key)) {
            updateNode(key);
        } else {
            size++;
            if (size > capacity) {
                HeapNode<T> removedNode = minHeap.poll();
                map.remove(removedNode.key);
                size--;
            }
            HeapNode<T> node = new HeapNode<>(key, val);
            map.put(key, node);
            minHeap.add(node);
        }
    }

    private HeapNode<T> updateNode(int key) {
        HeapNode<T> node = map.get(key);
        minHeap.remove(node);
        node.freq++;
        minHeap.add(node);
        return node;
    }

    public void popAll() {
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}

class HeapNode<T> {
    int key;
    int freq;
    T val;
    public HeapNode(int key, T val) {
        this.key = key;
        this.freq = 1;
        this.val = val;
    }
    @Override
    public String toString() {
        return "{key: " + key + ",freq: " +
                freq + ",val: " + val + "}";
    }
}