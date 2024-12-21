package threads.effectivejava.stopthread;

import java.util.concurrent.TimeUnit;

/*
Volatile keyword grants a var half of the synch guarantee.
You get visibility, but don't get atomicity.
 */
public class StopThreadVolatile {

    private static volatile boolean stopRequested;  //volatile guarantees visibility, not atomicity

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        stopRequested = true;
    }
}
