import java.util.Random;

// Định nghĩa class Car (bỏ public để gom chung vào một file)
class Car implements Runnable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance = 0;
        long startTime = System.currentTimeMillis();

        // Khởi tạo một đối tượng Random dùng chung cho cả vòng lặp
        Random random = new Random();

        // Sử dụng hằng số DISTANCE và STEP lấy từ class Main
        while (runDistance < Main.DISTANCE) {
            try {
                // Random tốc độ ngẫu nhiên từ 0 đến 19 KM/H
                int speed = random.nextInt(20);
                runDistance += speed;

                // Vẽ đường đua
                String log = "|";
                int percentTravel = (runDistance * 100) / Main.DISTANCE;
                for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
                    if (percentTravel >= i + Main.STEP) {
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";

                System.out.println("Car " + this.name + ": " + log + " " + Math.min(Main.DISTANCE, runDistance) + "KM");

                // Nghỉ 1 giây rồi chạy tiếp lượt sau
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car " + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car " + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}

// Class chứa hàm main (phải trùng tên với tên file: Main.java)
public class Main {
    public static final int DISTANCE = 100;
    public static final int STEP = 2;

    public static void main(String[] args) {
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);

        System.out.println("Distance: " + DISTANCE + "KM");

        // Kích hoạt các luồng bắt đầu đua đồng thời
        thread1.start();
        thread2.start();
        thread3.start();
    }
}