package threads.misc;

import java.util.concurrent.Semaphore;

/**
 * Control access to shared resource, allows specified concurrency.
 *
 * Semaphore config'd to allow 2 threads access at a time.
 */
public class SemaphoreExample {

    //allow two threads to access resource concurrently
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() +
                    " is accessing the resource.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);
        Thread t5 = new Thread(task);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
