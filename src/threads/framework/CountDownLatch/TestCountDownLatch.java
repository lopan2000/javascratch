package threads.framework.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        try (ExecutorService exec = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 3; i++) {
                exec.submit(() -> {
                    for (int x = 0; x < 100_000; x++) {
                        System.out.println(Thread.currentThread().getName() + ": " + x);
                    }
                    latch.countDown();
                });
            }
        }

        latch.await();
        System.out.println("Latch opened, all threads processing complete.");
    }
}
