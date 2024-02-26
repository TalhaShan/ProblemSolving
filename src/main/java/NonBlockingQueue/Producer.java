package NonBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Message msg = new Message("Message: " + i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced msg " + msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Message exit = new Message("EXIT");
        queue.add(exit);
    }
}
/** Read **/
//if the queue is full, add() fails with an exception whereas put() blocks.
//https://www.baeldung.com/java-concurrent-queues#:~:text=ConcurrentLinkedQueue,Compare%2DAnd%2DSwap).