package threads.concurrencyjenkov;

public class JavaMemoryModel {
    public static void main(String[] args) {
        //separateObjects();
        //sharedObject();
        //sharedObject2();
        sharedObject3();
    }

    /**
     * Each thread has its own 'i' on its thread-stack
     * and own 'count' on heap.
     */
    private static void separateObjects() {
        Runnable r1 = new MyRunnable();
        Runnable r2 = new MyRunnable();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }

    /**
     * Each thread has its own 'i' on its thread-stack,
     * but shares 'count' on heap.
     */
    private static void sharedObject() {
        Runnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }

    /**
     * Each thread has its own 'i' on its thread-stack,
     * but shares 'count' and 'myObject' on heap.
     */
    private static void sharedObject2() {
        Runnable r = new MyRunnable2(new MyObject());
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }

    /**
     * Fixes issue in sharedObject() by using MyRunnable3
     * which synchronizes updates to shared count field.
     */
    private static void sharedObject3() {
        Runnable r = new MyRunnable3();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }


    /**
     * Has problem when one instance is shared across mult threads
     * since count is shared.  There will be cases where t1 is
     * in the middle of incrementing i when t2 starts incrementing i
     * so t2 takes the same val of i as t1 took, so t2 will end up
     * overwriting t1's increment with the same value, so instead
     * of t1, t2 causing two increments, only one occurs.
     */
    private static class MyRunnable implements Runnable {

        private int count = 0;

        @Override
        public void run() {
            /*
            Even if a MyRunnable instance is shared across Threads,
            each thread gets its own stack-local ref to its own myObject
            on heap.
             */
            MyObject myObject = new MyObject();

            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() +
                    ": " + count + ", myObject: " + myObject);
        }
    }

    private static class MyRunnable2 implements Runnable {

        private int count = 0;
        private MyObject myObject;

        public MyRunnable2(MyObject myObject) {
            this.myObject = myObject;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() +
                    ": " + count + ", myObject: " + myObject);
        }
    }

    /**
     * Fixes issue in MyRunnable.
     */
    private static class MyRunnable3 implements Runnable {

        private int count = 0;

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (this) {
                    count++;
                }
            }
            System.out.println(Thread.currentThread().getName() +
                    ": " + count);
        }
    }

    private static class MyObject {}
}
