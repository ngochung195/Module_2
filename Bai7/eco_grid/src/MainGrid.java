/**
 * HỆ THỐNG NĂNG LƯỢNG ECOGRID (LEGACY CODE)
 */
abstract class HardwareDevice {
    String id;
    double voltage;
    double temperature;

    public HardwareDevice(String id, double voltage, double temperature) {
        this.id = id;
        this.voltage = voltage;
        this.temperature = temperature;
    }

    public abstract void monitorEnergy();

}

interface CloudConnectable {
    public abstract void connectToCloud();

}

class BatteryBank extends HardwareDevice implements CloudConnectable {
    public BatteryBank(String id, double voltage, double temperature) {
        super(id, voltage, temperature);
    }

    @Override
    public void monitorEnergy() {
        System.out.println("Battery " + id + " đang xả điện ở mức: " + voltage + "V");
    }

    @Override
    public void connectToCloud() {
        System.out.println("Battery " + id + " đang gửi dữ liệu qua sóng Wifi...");
    }
}

class CloudBillingService implements CloudConnectable {
    private String id;
    private String apiEndpoint;

    public CloudBillingService(String id, String apiEndpoint) {
        this.id = id;
        this.apiEndpoint = apiEndpoint;
    }

    @Override
    public void connectToCloud() {
        System.out.println("Billing Service đang kết nối API bảo mật tới Cloud...");
    }

    public void processBills() {
        System.out.println("[Hệ thống] Đang quét và xử lý hóa đơn điện toán đám mây...");
    }
}

public class MainGrid {
    public static void main(String[] args) {
        CloudConnectable[] cloudNodes = {
                new BatteryBank("BAT_LIS_01", 48.5, 32.2),
                new CloudBillingService("BILL_CLOUD_01", "https://api.ecogrid.vn/v1/billing")
        };

        System.out.println("=== KHỞI CHẠY HỆ THỐNG MẠNG LƯỚI ECOGRID ===");

        for (CloudConnectable node : cloudNodes) {
            node.connectToCloud();
        }

        System.out.println("\n=== KIỂM CHỨNG TÍNH AN TOÀN DỮ LIỆU ===");

        // Khởi tạo cụ thể dịch vụ phần mềm để kiểm tra thuộc tính
        CloudBillingService billingService = new CloudBillingService("BILL_CLOUD_01",
                "https://api.ecogrid.vn/v1/billing");
        // System.out.println(billingService.voltage);
        System.out.println("-> Trạng thái: SẠCH SẼ VÀ AN TOÀN.");
        System.out.println(
                "-> Minh chứng: Lớp CloudBillingService hoàn toàn cô lập, không còn mang bất kỳ thuộc tính lỗi hay giá trị rác nào liên quan đến vật lý (voltage, temperature).");
    }
}