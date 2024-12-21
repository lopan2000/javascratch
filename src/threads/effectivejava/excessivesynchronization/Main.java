package threads.effectivejava.excessivesynchronization;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        //example01();
        //example02();
        example03();
    }

    //no issues
    private static void example01() {

        ObservableSet<Integer> set =
                new ObservableSet<>(new HashSet<>());

        set.addObserver((s, e) -> System.out.println(e));

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    private static void example02() {

        ObservableSet<Integer> set =
                new ObservableSet<>(new HashSet<>());

        /*
        Note: there's no this ctx in lambdas, that's why we're using anon-class
         */
        set.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    /*
                    Causes a ConcurrentModificationException in ObservableSet.notifyElementAdded()
                    since we are in the midst of iterating over the observers collection there,
                    yet here we are trying to alter that collection by removing this observer
                    which is not allowed in Java.
                     */
                    s.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    private static void example03() {

        ObservableSet<Integer> set =
                new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    // >= Java 21 AutoClosable support
                    try (ExecutorService exec = Executors.newSingleThreadExecutor()) {
                        /*
                        Submit a Callable.  Upon completion it returs a Future.
                        Call get() on the Future to retrieve the result of the
                        Callable.
                         */
                        /*
                        On one hand:
                            Main thread already is holding a lock on observers, so
                            our new thread is blocked waiting to enter removeObserver.
                        On the other hand:
                            Main thread is waiting for new thread to complete removeObserver()
                            since main thread has a pending get() call on the task's Future which
                            never arrives.
                        Thus:
                            We have a deadlock.
                         */
                        Future<Boolean> future = exec.submit(() -> s.removeObserver(this)); //submit a Callable (expressed as a Lambda)
                        future.get(); //causes main thread to wait for new thread to complete

                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    }
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}