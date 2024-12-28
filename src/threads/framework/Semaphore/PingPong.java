package threads.framework.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class PingPong {

    public static void main(String[] args) {

        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);

        try (ExecutorService exec = Executors.newFixedThreadPool(2)) {
            exec.submit(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        s1.acquire();
                        System.out.println("Player 1 hits the ball.");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        s2.release();
                    }
                }
            });
            exec.submit(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        s2.acquire();
                        System.out.println("Player 2 hits the ball.");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        s1.release();
                    }
                }
            });
        }
    }
}
