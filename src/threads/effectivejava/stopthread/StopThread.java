package threads.effectivejava.stopthread;

import java.util.concurrent.TimeUnit;

public class StopThread {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        /*
        backgroundThread doesn't see this state change w/o sync around the var.
        We have atomicity (r/w of boolean primative has it implicitly),
        but, we don't have the visibility guarantee.

        Synchronization guarantees both:
            1) atomicity
            2) inter-thread visibility on updates to a shared var.
         */
        stopRequested = true;
    }
}