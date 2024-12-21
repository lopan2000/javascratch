package threads.effectivejava.concurrentcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        testConcurrentHashMap();
    }

    private static void testConcurrentHashMap() {

        ConcurrentMap<Integer, Integer> map = new ConcurrentHashMap<>();

        //add 10 tasks which update the map
        List<Callable<Void>> tasks = new ArrayList<>();
        for (int t = 0; t < 10; t++) {
            tasks.add(() -> {
                for (int i = 0; i < 10000; i++) {
                    map.merge(i, 1, Integer::sum);
                }
                return null;
            });
        }

        try (ExecutorService exec = Executors.newCachedThreadPool()) {
            //submit all tasks at once and wait for their completion
            exec.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        map.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
