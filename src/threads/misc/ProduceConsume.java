package threads.misc;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Uses ReentrantLock for mutex, Condition for sync -- is this really a good example, isn't overlap between lock and conditions?
 */
public class ProduceConsume {

    public static void main(String[] args) {
        MessageBox messageBox = new MessageBox();
        Thread producer = new Thread(() -> {
            List<String> messages = List.of("a","b","c","d","e");
            for (String msg : messages) {
                messageBox.produce(msg);
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                messageBox.consume();
            }
        });
        producer.start();
        consumer.start();
    }

    private static class MessageBox {

        private String message;
        private boolean isEmpty = true;
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition canProduce = lock.newCondition();
        private final Condition canConsume = lock.newCondition();

        public void produce(String msg) {
            lock.lock();
            try {
                if (!isEmpty) {
                    canProduce.await();
                }
                this.message = msg;
                isEmpty = false;
                canConsume.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }

        public void consume() {
            lock.lock();
            try {
                if (isEmpty) {
                    canConsume.await();
                }
                System.out.println("Consumed message: " + message);
                isEmpty = true;
                canProduce.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
