package threads.effectivejava.nextserialnumber;

import java.util.ArrayList;

public class NextSerialNumber {

    private static volatile int nextSerialNumber = 0;

    private static int generateSerialNumber() {
        /*
        Non-atomic operation:
        1) copy curr (old) val
        2) incr curr (old) -> next val
        3) return curr (old) val
         */
        return nextSerialNumber++;
    }

    public static void main(String[] args) {
        //test01();
        test02();
    }

    //no problems since only one thread, final printed val = 99999
    private static void test01() {
        new Thread(getRunnable(100000)).start();
    }

    //problem since we have 10 threads, final printed val not up to 99999
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