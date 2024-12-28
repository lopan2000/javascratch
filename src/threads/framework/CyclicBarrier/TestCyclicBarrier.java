package threads.framework.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3,
                () -> System.out.println("Barrier condition satisfied."));

        try (ExecutorService exec = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 3; i++) {
                exec.submit(() -> {
                    for (int x = 0; x < 100_000; x++) {
                        System.out.println(Thread.currentThread().getName() + ": " + x);
                    }
                    try {
                        barrier.await(); //once all 3 threads awaiting, the barrier opens
                    } catch (InterruptedException | BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }
}
