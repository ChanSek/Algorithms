package Threads;

public class OddEven {

    static int number = 0;
    static boolean isOdd = false;

    public static void main(String... args) throws Exception {
        Odd odd = new Odd();
        Even even = new Even();

        odd.start();
        even.start();

        odd.join();
        even.join();
    }

    static class Odd extends Thread {
        public void run() {
            synchronized(this) {
                try {
                    if (isOdd) {
                        wait();
                    }    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Odd - " + OddEven.number);
                OddEven.number++;
                OddEven.isOdd = false;
                notify();
            }
        }
    }

    static class Even extends Thread {
        public void run() {
            synchronized(this) {
                try {
                    if (!isOdd) {
                        wait();
                    }    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Even - " + OddEven.number);
                OddEven.number++;
                OddEven.isOdd = true;
                notify();
            }
        }
    }
}
