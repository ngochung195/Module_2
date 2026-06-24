public class AbsoluteNumberCalculator {
    public static int findAbsolute(int number) {
        if (number < 0) {
            return -number; // Nếu là số âm thì đảo dấu để lấy giá trị tuyệt đối
        }
        return number; // Nếu là số dương hoặc 0 thì giữ nguyên
    }
}