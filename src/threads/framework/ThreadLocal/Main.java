package threads.framework.ThreadLocal;

public class Main {

    public static void main(String[] args) {

        ThreadLocal<String> name =
                ThreadLocal.withInitial(() -> "n/a");

        Thread t1 = new Thread(() -> {
            name.set("Jason");
            System.out.println(Thread.currentThread().getName() + ": " + name.get());
        });
        Thread t2 = new Thread(() -> {
            name.set("Lopez");
            System.out.println(Thread.currentThread().getName() + ": " + name.get());
        });
        t1.start();
        t2.start();
    }
}