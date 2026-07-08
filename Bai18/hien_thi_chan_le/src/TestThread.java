class OddThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println(i);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("OddThread bi ngat " + e.getMessage());
        }
    }
}

class EvenThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println(i);

                Thread.sleep(15);
            }
        } catch (InterruptedException e) {
            System.out.println("EvenThread bi ngat " + e.getMessage());
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        oddThread.start();

        try {
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        evenThread.start();
    }
}