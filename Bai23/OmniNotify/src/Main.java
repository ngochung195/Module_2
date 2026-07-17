interface MessageSender {
    void send(String message, String recipient);
}

// Kênh Email
class EmailSender implements MessageSender {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Kết nối SMTP Server...");
        System.out.println("Gửi EMAIL tới " + recipient + ": " + message);
    }
}

// Kênh SMS
class SmsSender implements MessageSender {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Kết nối Telecom API...");
        System.out.println("Gửi SMS tới " + recipient + ": " + message);
    }
}

// Kênh Telegram (Thêm mới cực kỳ dễ dàng)
class TelegramSender implements MessageSender {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Kết nối Telegram Bot API...");
        System.out.println("Gửi TELEGRAM tới " + recipient + ": " + message);
    }
}

class ZaloSender implements MessageSender {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Kết nối Zalo OA Official Account...");
        System.out.println("Gửi ZALO tới " + recipient + ": " + message);
    }
}

class NotificationService {
    private MessageSender messageSender;

    // Dependency Injection qua Constructor
    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    // Hoặc cho phép thay đổi chiến lược linh hoạt qua Setter (Runtime)
    public void setSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendNotification(String message, String recipient) {
        if (messageSender == null) {
            throw new IllegalStateException("Chưa cấu hình kênh gửi thông báo!");
        }
        // Gọi lệnh ủy thác xử lý, không cần quan tâm là kênh gì!
        messageSender.send(message, recipient);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- KHỞI CHẠY HỆ THỐNG OMNINOTIFY MỚI ---\n");

        // 1. Khởi tạo dịch vụ với kênh Email ban đầu
        NotificationService service = new NotificationService(new EmailSender());
        service.sendNotification("Bạn có 1 hóa đơn mới", "user@email.com");
        System.out.println("----------------------------------------");

        // 2. Chuyển sang kênh Telegram linh hoạt bằng Setter Injection
        service.setSender(new TelegramSender());
        service.sendNotification("Cảnh báo bảo mật: Phát hiện đăng nhập lạ", "@username_telegram");
        System.out.println("----------------------------------------");

        // 3. THỬ THÁCH MỞ RỘNG: Gọi kênh ZaloSender mới tinh
        service.setSender(new ZaloSender());
        service.sendNotification("Cảm ơn bạn đã quan tâm đến dịch vụ", "0901234567");
        System.out.println("----------------------------------------");
    }
}