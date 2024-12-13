package threads.concurrencyjenkov;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreads {
    public static void main(String[] args) {
        //ex01();
        ex02();
    }

    /**
     * Create virtual thread
     */
    private static void ex01() {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i: " + i);
            }
        };

        Thread vt1 = Thread.ofVirtual().start(runnable);
        Thread vt2 = Thread.ofVirtual().unstarted(runnable);
        vt2.start();

        /*
          Need this blocking, otherwise the main user thread terminates
          instantly since virtual threads are daemons.
         */
        try {
            vt2.join(); //main thread blocks until vt2 finishes
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Create 100K virtual threads and have main user thread block until
     * all are finished
     */
    private static void ex02() {

        List<Thread> vThreads = new ArrayList<>();

        int vThreadCount = 100000; //closure for vThread lambdas below

        for (int i = 0; i < vThreadCount; i++) {
            int vThreadIndex = i;
            Thread vThread = Thread.ofVirtual().start(() -> {
                int result = 0;
                while (result < 10) {
                    result++;
                }
                System.out.println("Result[" + vThreadIndex + "]: " + result);
            });
            vThreads.add(vThread);
        }

        //block until all vThreads are finished (isn't it possible for some vts to complete before joined?)
        for (Thread vThread : vThreads) {
            try {
                vThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
