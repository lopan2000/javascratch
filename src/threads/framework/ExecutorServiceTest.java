package threads.framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        };
        try (ExecutorService exec = Executors.newFixedThreadPool(2)) {
            exec.execute(runnable);
            exec.execute(runnable);
            exec.shutdown();
        }

    }
}
