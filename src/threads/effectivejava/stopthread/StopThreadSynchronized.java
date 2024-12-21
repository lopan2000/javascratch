package threads.effectivejava.stopthread;

import java.util.concurrent.TimeUnit;

/*
Synchronization is not guaranteed to work unless 'both' read and write
operations are synchronized.  One might have thought only need to synch writes
to guarantee visibility.

If the read isn't synch'd, the thread might keep reading from stale CPU-cached data
instead of reading the latest value in main memory.
 */
public class StopThreadSynchronized {

    private static boolean stopRequested;

    //solves visibility problem in original StopThread example
    private static synchronized void requestStop() {
        stopRequested = true;
    }

    //solves visibility problem in original StopThread example
    private static boolean isStopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!isStopRequested()) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
