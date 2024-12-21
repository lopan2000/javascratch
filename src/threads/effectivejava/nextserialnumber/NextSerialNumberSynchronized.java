package threads.effectivejava.nextserialnumber;

import java.util.ArrayList;

public class NextSerialNumberSynchronized {

    private static int nextSerialNumber = 0;        //removed volatile since we access via a synch'd (granting visibility)

    /*
    synchronized gives us both the atomicity we need, and visibility
    so don't need our nextSerialNumber var to be declared volatile anymore.
     */
    private static synchronized int generateSerialNumber() {
        return nextSerialNumber++;
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
