package threads.jpmorgan;

public class PrintOddEvenInSeparateThreadsWithSync {

    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {


    }

    private static class MyRunnable implements Runnable {

        private int count = 0;

        @Override
        public void run() {
            while (count < 10) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread() + ": " + count);
                    count++;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    lock.notifyAll();
                }
            }
        }
    }
}
