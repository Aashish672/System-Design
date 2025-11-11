package messagequeue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue {
    private Queue<String> queue = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // Enqueue a message
    public void send(String message) {
        lock.lock();
        try {
            queue.add(message);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    // Dequeue a message

    public String receive() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }
}
