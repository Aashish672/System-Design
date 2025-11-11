package messagequeue;

public class Producer implements Runnable {

    private MessageQueue mq;
    private int id;
    private String message;

    public Producer(MessageQueue mq, int id, String message) {
        this.mq = mq;
        this.id = id;
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Producer " + id + " sending: " + message);
        mq.send(message);
    }
}
