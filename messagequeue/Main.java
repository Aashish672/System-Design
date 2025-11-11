package messagequeue;

public class Main {

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        Thread producerThread = new Thread(new Producer(messageQueue, 1, "Hello, World!"));
        Thread consumerThread = new Thread(new Consumer(messageQueue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
