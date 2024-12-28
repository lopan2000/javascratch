package threads.framework.ReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//(TODO) come up with better example than this
public class SimpleUse {

    private static final int n = 1_000_000;
    private static int counter = 0;

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true); //fair
        Condition conditiion = lock.newCondition();

        try (ExecutorService exec = Executors.newFixedThreadPool(2)) {
            for (int i = 0; i < 2; i++) {
                exec.submit(() -> {
                    for (int x = 0; x < n/2; x++) {
                        try {
                            lock.lock();
                            System.out.println(Thread.currentThread().getName() + ": " + counter);
                            counter++;
                        } finally {
                            lock.unlock();
                        }
                    }
                });
            }
        }

    }
}
