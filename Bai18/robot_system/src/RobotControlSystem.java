import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * HỆ THỐNG ROBOLOGISTICS (ĐÃ ĐƯỢC TỐI ƯU VÀ PHÁ DEADLOCK)
 */
public class RobotControlSystem {

    // --- GIẢI PHÁP 1: ATOMICINTEGER CHO TRẠM CÂN ---
    // Chuyển đổi sang AtomicInteger để đảm bảo tính nguyên tử (Thread-safe)
    private final AtomicInteger totalWeight = new AtomicInteger(0);

    public void dropItem() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Cộng 10 một cách an toàn luồng mà không cần dùng từ khóa synchronized
        totalWeight.addAndGet(10);
    }

    public int getTotalWeight() {
        return totalWeight.get();
    }

    // --- GIẢI PHÁP 2: REENTRANTLOCK CHO CÁC KHU VỰC (ZONE) ---
    static class Zone {
        String name;
        // Mỗi khu vực sở hữu một ổ khóa ReentrantLock riêng biệt
        final Lock lock = new ReentrantLock();

        public Zone(String name) {
            this.name = name;
        }
    }

    public void moveRobot(Zone currentZone, Zone nextZone, String robotName) {
        // Vòng lặp liên tục thử lại nếu bị chặn (ngăn ngừa Deadlock)
        while (true) {
            boolean acquiredCurrent = false;
            boolean acquiredNext = false;

            try {
                // Thử lấy khóa tại khu vực hiện tại trong tối đa 1 giây
                acquiredCurrent = currentZone.lock.tryLock(1, TimeUnit.SECONDS);

                if (acquiredCurrent) {
                    System.out.println(
                            robotName + " đã chiếm " + currentZone.name + " và đang nhìn sang " + nextZone.name);
                    Thread.sleep(50); // Giả lập thời gian di chuyển/chuẩn bị

                    // Thử lấy khóa tại khu vực tiếp theo trong tối đa 1 giây
                    acquiredNext = nextZone.lock.tryLock(1, TimeUnit.SECONDS);

                    if (acquiredNext) {
                        // Lấy được cả 2 khóa -> Di chuyển thành công
                        System.out.println(">>> SUCCESS: " + robotName + " đã di chuyển thành công từ "
                                + currentZone.name + " sang " + nextZone.name);
                        break; // Thoát khỏi vòng lặp vì đã hoàn thành nhiệm vụ
                    } else {
                        // Thất bại khi lấy khóa tiếp theo -> Phải nhường đường
                        System.out.println("!!! CONFLICT: " + robotName + " KHÔNG THỂ chiếm " + nextZone.name
                                + ". Đang nhả " + currentZone.name + " để nhường đường...");
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(robotName + " bị ngắt quãng quá trình di chuyển.");
                Thread.currentThread().interrupt();
                break;
            } finally {
                // Giải phóng khóa trong khối finally để đảm bảo an toàn tuyệt đối
                if (acquiredNext) {
                    nextZone.lock.unlock();
                }
                if (acquiredCurrent) {
                    currentZone.lock.unlock();
                }
            }

            // Chờ một khoảng ngắn ngẫu nhiên trước khi thử lại để tránh xung đột lặp đi lặp
            // lại (Livelock)
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RobotControlSystem system = new RobotControlSystem();

        // 1. Kiểm tra Race Condition với 500 robot cùng thả hàng
        System.out.println("--- Bắt đầu kiểm tra Trạm Cân ---");
        Thread[] robots = new Thread[500];
        for (int i = 0; i < 500; i++) {
            robots[i] = new Thread(system::dropItem);
            robots[i].start();
        }
        for (Thread r : robots)
            r.join(); // Chờ tất cả robot hoàn thành nhiệm vụ

        System.out.println("Kỳ vọng: 5000 kg. Thực tế trạm cân ghi nhận: " + system.getTotalWeight() + " kg");

        // 2. Kiểm tra giải quyết Deadlock tại ngã tư khu vực
        System.out.println("\n--- Bắt đầu mô phỏng điều phối Ngã Tư ---");
        Zone zoneA = new Zone("Khu A");
        Zone zoneB = new Zone("Khu B");

        // Robot-Alpha đi từ A -> B, Robot-Beta đi từ B -> A (Xung đột đối đầu)
        Thread robot1 = new Thread(() -> system.moveRobot(zoneA, zoneB, "Robot-Alpha"));
        Thread robot2 = new Thread(() -> system.moveRobot(zoneB, zoneA, "Robot-Beta"));

        robot1.start();
        robot2.start();

        robot1.join();
        robot2.join();

        System.out.println("\n--- CHÚC MỪNG: Hệ thống vận hành trơn tru và tự động kết thúc an toàn! ---");
    }
}