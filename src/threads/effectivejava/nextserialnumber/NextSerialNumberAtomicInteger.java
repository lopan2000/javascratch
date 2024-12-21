package threads.effectivejava.nextserialnumber;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class NextSerialNumberAtomicInteger {

    private static final AtomicInteger nextSerialNumber = new AtomicInteger();

    private static int generateSerialNumber() {
        return nextSerialNumber.getAndIncrement();
    }

    public static void main(String[] args) {
        test02();
    }

    //no longer a problem and our final value is 99999
    private static void test02() {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(getRunnable(10000)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static Runnable getRunnable(int n) {
        return () -> {
            for (int i = 0; i < n; i++) {
                System.out.println(Thread.currentThread().getName() +
                        ": " + generateSerialNumber());
            }
        };
    }
}
