/**
 * HỆ THỐNG QUÉT AN NINH - CYBERSCAN (LEGACY CODE)
 */
public class SecurityScanner {
    public static void main(String[] args) {
        String[] users = { "USER_01", null, "BANNED_01", "USER_02", "ADMIN_01", "USER_03", "USER_04" };
        int[] loginAttempts = { 1, 0, 8, 4, 0, 5, 2 };
        boolean[] isLocked = { false, false, true, false, false, false, false };

        System.out.println("--- BẮT ĐẦU QUÉT HỆ THỐNG ---");
        long startTime = System.nanoTime();

        for (int i = 0; i < users.length; i++) {
            String currentUser = users[i];

            if (currentUser == null || isLocked[i] || currentUser.startsWith("BANNED")) {
                continue;
            }

            if (currentUser.startsWith("ADMIN")) {
                System.out.println("Đã tìm thấy Admin hệ thống: " + currentUser);
                break;
            }

            if (loginAttempts[i] > 3) {
                System.out.println("Cảnh báo: " + currentUser + " sai mật khẩu " + loginAttempts[i] + " lần.");
                continue;
            }

        }

        long endTime = System.nanoTime();
        System.out.println("Thời gian quét: " + (endTime - startTime) + " nano giây.");
    }
}