import java.io.File;

// 1. Unchecked Exception cho dữ liệu sai logic
class InvalidCustomerDataException extends RuntimeException {
    public InvalidCustomerDataException(String message) {
        super(message);
    }
}

// 2. Checked Exception cho rủi ro môi trường (mất file)
class MissingDocumentException extends Exception {
    public MissingDocumentException(String message) {
        super(message);
    }
}

public class CustomerOnboardingService {

    public void registerAccount(String name, int age, String idCardFilePath) throws MissingDocumentException {

        // Giải quyết Smell 1: Dùng Unchecked Exception
        if (age < 18) {
            throw new InvalidCustomerDataException("Lỗi logic: Khách hàng chưa đủ 18 tuổi!");
        }

        // Giải quyết Smell 2: Dùng Unchecked Exception
        if (name == null || name.isEmpty()) {
            throw new InvalidCustomerDataException("Lỗi logic: Tên khách hàng không được để trống!");
        }

        // Tình huống 3: Giữ lại Checked Exception vì đây là lỗi hệ thống ngoại cảnh
        File file = new File(idCardFilePath);
        if (!file.exists()) {
            throw new MissingDocumentException("Hệ thống: Không tìm thấy file CCCD trên máy chủ, vui lòng tải lại!");
        }

        System.out.println("Tạo tài khoản thành công cho: " + name);
    }

    public static void main(String[] args) {
        CustomerOnboardingService service = new CustomerOnboardingService();

        System.out.println("=== CHẠY TEST CASE 1: Dữ liệu đúng, lỗi file ===");
        try {
            service.registerAccount("Nguyen Van A", 20, "path/to/wrong_file.png");
        } catch (MissingDocumentException e) {
            System.out.println("[XỬ LÝ THÀNH CÔNG] Hiện thông báo: " + e.getMessage());
        }

        System.out.println("\n=== CHẠY TEST CASE 2: Dữ liệu sai (Age = 15) ===");
        System.out.println("Hệ thống sẽ Fail-Fast và văng Stack Trace ngay lập tức...");

        try {
            service.registerAccount("Nguyen Van B", 15, "path/to/valid_file.png");
        } catch (MissingDocumentException e) {
            System.out.println("Dòng này sẽ không bao giờ chạy trong Test 2.");
        }
    }
}