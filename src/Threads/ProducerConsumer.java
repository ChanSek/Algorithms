package Threads;

public class ProducerConsumer {

    private int value;
    public boolean isProduced;

    public synchronized void put(int value) {
        try {
            while(isProduced) wait();
            this.value = value;
            isProduced = true;
            System.out.println("Produced - " + value);
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int get() {
        try {
            while(!isProduced) wait();
            isProduced = false;
            System.out.println("Consumed - " + value);
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String... args) throws Exception {
        ProducerConsumer obj = new ProducerConsumer();
        new Producer(obj);
        new Consumer(obj);
    }
}
