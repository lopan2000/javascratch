package threads.framework.ReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO:
 * 1) protect again spurious wakeups by surrounding condition awaits() in loop.
 * 2) if p2 starts first, there appear to be intermittent issues
 */
public class PingPong2 {

    public static void main(String[] args) throws Exception {

        ReentrantLock lock = new ReentrantLock();
        Condition player1turn = lock.newCondition();
        Condition player2turn = lock.newCondition();
        final Boolean isPlayerOneTurn = true;

        try (ExecutorService exec = Executors.newFixedThreadPool(2)) {

            Runnable p1 = () -> {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        System.out.println("Player 1 hits the ball.");
                        player2turn.signal();
                        /*
                        1) release assoc lock ->WAITING
                        2) once signal arrives ->BLOCKED
                        3) once lock re-acquired ->RUNNABLE
                         */
                        player1turn.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                }
            };

            Runnable p2 = () -> {
                for (int i = 0; i < 10; i++) {
                    lock.lock();
                    try {
                        /*
                        1) release assoc lock ->WAITING
                        2) once signal arrives ->BLOCKED
                        3) once lock re-acquired ->RUNNABLE
                         */
                        player1turn.await();
                        System.out.println("Player 2 hits the ball.");
                        player1turn.signal();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                }
            };

            exec.submit(p1);
            //TimeUnit.SECONDS.sleep(5);
            exec.submit(p2);
        }
    }
}