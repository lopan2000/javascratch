package interview.cache;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<T> {

    protected Map<Integer, Node<T>> map = new HashMap<>(); //for O(1) node lookup
    protected Node<T> sHead, sTail; //sentinel head and tail for doubly-linked-list
    protected int capacity, size;

    protected AbstractCache(int capacity) {
        this.sHead = new Node<T>();
        this.sTail = new Node<T>();
        this.capacity = capacity;
        sHead.next = sTail; //point sentinel head to sentinel tail
        sTail.prev = sHead; //point sentinel tail to sentinel head
    }

    protected abstract T get(int key);

    protected abstract void put(int key, T val);

    protected void moveToHead(Node<T> node) {
        removeNode(node);
        addToHead(node);
    }

    protected void removeNode(Node<T> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    protected void addToHead(Node<T> node) {
        node.prev = sHead;
        node.next = sHead.next;
        sHead.next.prev = node;
        sHead.next = node;
    }

    protected Node<T> removeTail() {
        Node<T> node = sTail.prev;
        removeNode(node);
        return node;
    }

    public void print() {
        Node<T> curr = sHead.next;
        while (curr != null && curr != sTail) {
            System.out.println("{" + curr.key + "," + curr.val + "}");
            curr = curr.next;
        }
    }
}
