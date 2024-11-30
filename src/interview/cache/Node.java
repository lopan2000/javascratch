package interview.cache;

public class Node<T> {
    int key;
    T val;
    Node<T> prev, next;
    public Node() {}
    public Node(int key, T val) {
        this.key = key;
        this.val = val;
    }
}
