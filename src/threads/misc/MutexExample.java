package threads.misc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Mutex -- "(mutually) exclusive" access
 *
 * Only one thread can acquire the lock at a time so
 * other threads block until it is released. So, there
 * is no guarantee on the order threads perform task,
 * but they perform the task sequentially.
 */
public class MutexExample {

    //allows for nested lock acquisition and release
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() +
                        " is acquiring the resource");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
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
