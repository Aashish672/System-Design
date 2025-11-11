package messagequeue;

public class Consumer implements Runnable {

    private MessageQueue mq;

    public Consumer(MessageQueue mq) {
        this.mq = mq;
    }

    @Override
    public void run() {
        String msg = mq.receive();
        System.out.println("Consumer received: " + msg);
    }
}
