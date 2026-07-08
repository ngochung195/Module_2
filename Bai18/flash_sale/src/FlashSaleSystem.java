import java.util.concurrent.atomic.AtomicInteger;

public class FlashSaleSystem {

    // --- MODULE 1: BÁN HÀNG ---
    private int stock = 100; // Tồn kho ban đầu 100 chiếc

    public void buyIphone() {
        // Sử dụng khối synchronized để đảm bảo tại một thời điểm chỉ 1 Thread được kiểm
        // tra và trừ kho
        synchronized (this) {
            if (stock > 0) {
                try {
                    // Giả lập độ trễ khi kết nối Database
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                stock--; // An toàn: Đã được bảo vệ bởi lock
                System.out.println(Thread.currentThread().getName() + " mua thành công. Kho còn: " + stock);
            }
        }
    }

    // --- MODULE 2: ĐỔI QUÀ ---
    static class VIPUser {
        String name;

        public VIPUser(String name) {
            this.name = name;
        }
    }

    public void swapGifts(VIPUser userA, VIPUser userB) {
        // Tránh trường hợp tự đổi quà cho chính mình dẫn đến lặp vô hạn (nếu có)
        if (userA == userB)
            return;

        // Định thứ tự khóa cố định dựa trên quy tắc so sánh Alphabet của Name (Lock
        // Ordering)
        VIPUser firstLock = userA.name.compareTo(userB.name) < 0 ? userA : userB;
        VIPUser secondLock = firstLock == userA ? userB : userA;

        // Luôn luôn khóa theo đúng thứ tự đã định sẵn, triệt tiêu hoàn toàn Circular
        // Wait
        synchronized (firstLock) {
            System.out.println(Thread.currentThread().getName() + " đã khóa " + firstLock.name);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(Thread.currentThread().getName() + " đang chờ khóa " + secondLock.name + "...");
            synchronized (secondLock) {
                System.out.println("Đổi quà thành công giữa " + userA.name + " và " + userB.name);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FlashSaleSystem system = new FlashSaleSystem();

        System.out.println("=== BẮT ĐẦU CHIẾN DỊCH FLASH SALE ===");
        // 1. Giải quyết Race Condition (1000 người tranh 100 cái đt)
        Thread[] buyers = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            buyers[i] = new Thread(() -> system.buyIphone(), "Người-dùng-" + (i + 1));
            buyers[i].start();
        }

        // Đợi các luồng mua hàng chạy xong để console gọn gàng hơn trước khi đổi quà
        for (Thread t : buyers) {
            t.join();
        }

        System.out.println("\n=== BẮT ĐẦU SỰ KIỆN ĐỔI QUÀ VIP ===");
        // 2. Giải quyết Deadlock
        VIPUser alice = new VIPUser("Alice");
        VIPUser bob = new VIPUser("Bob");

        // Luồng 1: Alice đổi quà với Bob
        Thread thread1 = new Thread(() -> system.swapGifts(alice, bob), "Luồng-Alice");
        // Luồng 2: Bob đổi quà với Alice
        Thread thread2 = new Thread(() -> system.swapGifts(bob, alice), "Luồng-Bob");

        thread1.start();
        thread2.start();
    }
}