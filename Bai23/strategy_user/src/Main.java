class User {
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

interface UserStorage {
    void store(User user);
}

class UserController {
    private UserStorage userStorage;

    // Constructor nhận vào một đối tượng UserStorage (Dependency Injection)
    public UserController(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    // Phương thức thay đổi chiến lược lưu trữ linh hoạt tại runtime nếu cần
    public void setUserStorage(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    // Gọi phương thức store() của chiến lược được inject vào để lưu dữ liệu
    public void store(User user) {
        if (userStorage == null) {
            throw new IllegalStateException("Chưa cấu hình phương thức lưu trữ dữ liệu!");
        }
        userStorage.store(user);
    }
}

class XMLStorage implements UserStorage {
    @Override
    public void store(User user) {
        System.out.println("[XML] Đang định dạng dữ liệu sang cấu trúc thẻ XML...");
        System.out.println("[XML] Đã ghi người dùng '" + user.getUsername() + "' (" + user.getEmail()
                + ") vào file users.xml thành công!");
    }
}

class MySQLStorage implements UserStorage {
    @Override
    public void store(User user) {
        System.out.println("[MySQL] Đang kết nối tới Cơ sở dữ liệu MySQL...");
        System.out.println("[MySQL] Chạy lệnh: INSERT INTO users (username, email) VALUES ('" + user.getUsername()
                + "', '" + user.getEmail() + "');");
        System.out.println("[MySQL] Đã lưu người dùng vào database thành công!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng dữ liệu mẫu
        User user = new User("nguyenvana", "ana@example.com");

        System.out.println("--- KỊCH BẢN 1: LƯU TRỮ VÀO FILE XML ---");
        // 1. Tạo UserController sử dụng XMLStorage
        UserController xmlController = new UserController(new XMLStorage());
        // 2. Gọi phương thức store() và quan sát kết quả
        xmlController.store(user);

        System.out.println("\n----------------------------------------\n");

        System.out.println("--- KỊCH BẢN 2: LƯU TRỮ VÀO CSDL MYSQL ---");
        // 1. Tạo UserController sử dụng MySQLStorage
        UserController mysqlController = new UserController(new MySQLStorage());
        // 2. Gọi phương thức store() và quan sát kết quả
        mysqlController.store(user);
    }
}