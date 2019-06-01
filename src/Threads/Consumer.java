package Threads;

/**
 * Consumer class to consume something produced by Producer class.
 */
public class Consumer implements Runnable {

    ProducerConsumer pc;
    Thread t;

    Consumer (ProducerConsumer pc) {
        this.pc = pc;
        t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        while(pc.get() != 9) { }
    }
}
