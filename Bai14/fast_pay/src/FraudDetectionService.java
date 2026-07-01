import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * HỆ THỐNG ĐỐI SOÁT FASTPAY (OPTIMIZED CODE)
 */
public class FraudDetectionService {

    /**
     * Thuật toán rùa bò: Duyệt lặp 2 lần O(n^2)
     */
    public List<Integer> findDuplicatesLegacy(int[] transactions) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < transactions.length; i++) {
            for (int j = i + 1; j < transactions.length; j++) {
                if (transactions[i] == transactions[j]) {
                    if (!duplicates.contains(transactions[i])) {
                        duplicates.add(transactions[i]);
                    }
                }
            }
        }
        return duplicates;
    }

    /**
     * THIẾT KẾ MỚI: Thuật toán tối ưu O(n) sử dụng HashSet
     */
    public List<Integer> findDuplicatesOptimized(int[] transactions) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        Set<Integer> addedToDuplicates = new HashSet<>();

        for (int transaction : transactions) {
            if (!seen.add(transaction)) {
                if (addedToDuplicates.add(transaction)) {
                    duplicates.add(transaction);
                }
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        FraudDetectionService service = new FraudDetectionService();

        // THU NGHIEM 1: Quy mo 100,000 giao dich (De so sanh ca 2 ham)
        int size1 = 100000;
        int[] logs1 = generateMockData(size1);

        System.out.println("=== THU NGHIEM 1: QUY MO " + size1 + " GIAO DICH ===");

        // Chay thu nghiem ham Legacy O(n^2)
        long startTime = System.currentTimeMillis();
        List<Integer> dupesLegacy = service.findDuplicatesLegacy(logs1);
        long endTime = System.currentTimeMillis();
        long legacyTime1 = (endTime - startTime);
        System.out.println("[Legacy O(n^2)] Trung lap: " + dupesLegacy + " | Thoi gian: " + legacyTime1 + " ms");

        // Chay thu nghiem ham Optimized O(n)
        startTime = System.currentTimeMillis();
        List<Integer> dupesOptimized = service.findDuplicatesOptimized(logs1);
        endTime = System.currentTimeMillis();
        long optimizedTime1 = (endTime - startTime);
        System.out.println(
                "[Optimized O(n)] Trung lap: " + dupesOptimized + " | Thoi gian: " + optimizedTime1 + " ms");

        // THU NGHIEM 2: Nang quy mo len 500,000 giao dich (Chi chay ham tinh gon de
        // tranh treo may)
        int size2 = 500000;
        int[] logs2 = generateMockData(size2);

        System.out.println("\n=== THU NGHIEM 2: NANG QUY MO LEN " + size2 + " GIAO DICH ===");
        System.out.println("(Bo qua ham Legacy vi co the gay sap/treo he thong do O(n^2) qua nang)");

        startTime = System.currentTimeMillis();
        List<Integer> dupesHuge = service.findDuplicatesOptimized(logs2);
        endTime = System.currentTimeMillis();
        System.out
                .println("[Optimized O(n)] Trung lap: " + dupesHuge + " | Thoi gian: " + (endTime - startTime) + " ms");
    }

    // Hàm helper sinh dữ liệu giả lập
    private static int[] generateMockData(int size) {
        int[] logs = new int[size];
        for (int i = 0; i < size; i++) {
            logs[i] = i;
        }
        logs[size - 1] = size / 2; // Cố tình tạo một phần tử trùng lặp ở giữa mảng
        return logs;
    }
}