class NumberGenerator implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(
                        "Thread " + Thread.currentThread() + " | Number " + (i + 1) + " | HashCode " + this.hashCode());

                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread bi ngat quang: " + e.getMessage());
        }
    }
}

public class MainNumberGenerator {
    public static void main(String[] args) {
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();

        Thread thread1 = new Thread(generator1, "Thread-1");
        Thread thread2 = new Thread(generator2, "Thread-2");

        thread1.start();
        thread2.start();
    }
}