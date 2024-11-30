package interview.cache;

public class Main {
    public static void main(String[] args) {
        testLFUCache();
    }

    private static void testLRUCache() {
        LRUCache<String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "a");
        lruCache.put(2, "b");
        lruCache.put(3, "c");
        lruCache.put(4, "d");
        lruCache.print();
    }

    private static void testLFUCache() {
        LFUCache<String> cache = new LFUCache<>(3);
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        for (int i = 0; i < 10; i++) {
            cache.get(1);
        }
        for (int i = 0; i < 5; i++) {
            cache.get(2);
        }
        for (int i = 0; i < 7; i++) {
            cache.get(3);
        }
        //so, freq {1:11, 2:6, 3:8}, so minHeap [2,3,1]
        cache.put(4, "d");
        //now, minHeap should be [4,3,1]
        cache.popAll();

    }

}
