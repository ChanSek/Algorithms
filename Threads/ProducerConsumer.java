public class ProducerConsumer {
    
    static boolean isProduced = false;
    static boolean isConsumed = false;

    public static void main(String... args) throws Exception {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

    static class Producer extends Thread {

        public void run() {
            synchronized(this) {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Produced - " + i);
                        ProducerConsumer.isProduced = true;
                        notify();
                        Thread.sleep(1000);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {

        public void run() {
            synchronized(this) {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Consumed - " + i);
                        ProducerConsumer.isConsumed = true;
                        notify();
                        Thread.sleep(1000);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
