package threads.concurrencyjenkov;

public class CreateStartStop {

    public static void main(String[] args) throws Exception {
        //ex01();
        //ex02();
        //ex03();
        ex04();
    }

    /**
     * Create two threads
     */
    private static void ex01() {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);
        };

        Thread t1 = new Thread(runnable, "t1");
        t1.start();
        Thread t2 = new Thread(runnable, "t2");
        t2.start();
    }

    /**
     * Thread t outlives main() thread keeping JVM alive.
     */
    private static void ex02() throws Exception {
        Runnable runnable = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running");
            }
        };

        Thread t = new Thread(runnable);
        t.start();

        Thread.sleep(3100);
        System.out.println("Terminating main() thread");
    }

    /**
     * Thread t set to daemon (~background thread) so it won't outlive main() thread.
     *
     * When all non-daemon ("user") threads have terminated, the shutdown seq
     * begins on the daemon threads.
     */
    private static void ex03() throws Exception {
        Runnable runnable = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running");
            }
        };

        Thread t = new Thread(runnable);
        t.setDaemon(true);
        t.start();

        Thread.sleep(3100);
        System.out.println("Terminating main() thread");
    }

    /**
     * Have main thread block until daemon thread t terminates.
     * If not set to explicitly block, the main thread would
     * terminate instantly.
     */
    private static void ex04() throws Exception {
        Runnable runnable = () -> {
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Running");
            }
        };

        Thread t = new Thread(runnable);
        t.setDaemon(true);
        t.start();

        try {
            t.join();   //blocks and returns when t terminates
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
