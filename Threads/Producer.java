/**
 * Producer class to produce something.
 */
public class Producer implements Runnable {

    ProducerConsumer pc;
    Thread t;

    Producer(ProducerConsumer pc) {
        this.pc = pc;
        t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;
        while(i < 10) {
            pc.put(i++);
        }
    }
}
