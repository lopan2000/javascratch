package threads.grok;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    private static volatile int counter = 0;
    private static final int TARGET_VALUE = 1000;
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

        List<Thread> readers = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            readers.add(new Thread(() -> {
                while (readValue() < TARGET_VALUE) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
        List<Thread> writers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            writers.add(new Thread(() -> {
                while (incrementValue() < TARGET_VALUE) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }

        System.out.println("start");

        readers.forEach(Thread::start);
        writers.forEach(Thread::start);

        readers.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        writers.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("end");
    }

    public static int incrementValue() {
        lock.writeLock().lock(); //allows 1 to hold at a time, can't acquire if anyone holding the resp. read-lock.
        try {
            Thread.sleep(1);
            if (counter < TARGET_VALUE) {
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        return counter;
    }

    public static int readValue() {
        lock.readLock().lock(); //allows n-concurrent acquisitions provided no one is holding the resp. write-lock.
        try {
            Thread.sleep(1);
            return counter;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return 0;
    }
}