package threads.framework.ReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Do you know what this means?  It means this damn thing doesn't work at all.
 */
public class TwoDiningPhilosophers {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition fork1available = lock.newCondition();
        Condition fork2available = lock.newCondition();
        Condition p1Thinking = lock.newCondition();
        Condition p2Thinking = lock.newCondition();

        try (ExecutorService exec = Executors.newFixedThreadPool(2)) {

            Runnable p1 = () -> {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        System.out.println("P1 thinking...");
                        p2Thinking.await();
                        fork1available.await();
                        fork2available.await();
                        System.out.println("P1 eats");
                        p1Thinking.signal();
                        fork1available.signal();
                        fork2available.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            };

            Runnable p2 = () -> {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        System.out.println("P2 thinking...");
                        p1Thinking.await();
                        fork1available.await();
                        fork2available.await();
                        System.out.println("P2 eats");
                        p2Thinking.signal();
                        fork1available.signal();
                        fork2available.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            };

            exec.submit(p1);
            exec.submit(p2);

            //impose p1 could eat first
            p2Thinking.signal();
            fork1available.signal();
            fork2available.signal();
        }
    }
}
