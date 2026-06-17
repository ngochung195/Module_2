/**
 * HỆ THỐNG PHÂN TÍCH TÀI CHÍNH - FINTRACK (OPTIMIZED CODE)
 */

package Bai3.FinTrack.src;

import java.util.Arrays;

public class FinTrackMemoryBug {
    public static void main(String[] args) {
        System.out.println("--- KHẢO SÁT BIẾN NGUYÊN THỦY (STACK) ---");
        int originalPrice = 500;
        int backupPrice = originalPrice; // Sao chép giá trị (Giá trị độc lập trên Stack)
        backupPrice = 700;

        // Kết quả: originalPrice vẫn là 500.
        System.out.println("Original Price: " + originalPrice);

        System.out.println("\n--- KHẢO SÁT MẢNG DỮ LIỆU (HEAP) - ĐÃ SỬA LỖI ---");
        int[] todayRates = { 10, 20, 30 };

        int[] backupRates = Arrays.copyOf(todayRates, todayRates.length);

        backupRates[0] = 99;

        System.out.println("Today Rate [0] (Gốc): " + todayRates[0]);
        System.out.println("Backup Rate [0] (Mới): " + backupRates[0]);

        System.out.println("\n--- LỖI HỆ THỐNG SẬP (NULL POINTER) - ĐÃ SỬA LỖI ---");

        // GIẢI PHÁP: Cấp phát bộ nhớ (khởi tạo mảng) trên Heap trước khi sử dụng
        int[] historyRates = new int[5];
        historyRates[0] = 15;

        // Hệ thống chạy mượt mà, không còn crash nữa
        System.out.println("Phần tử đầu tiên của History: " + historyRates[0]);
    }
}