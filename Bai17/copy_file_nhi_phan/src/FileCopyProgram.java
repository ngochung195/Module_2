import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyProgram {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CHUONG TRINH SAO CHEP TAP TIN (BYTE STREAM) ===");

        // 1. Nhap duong dan file nguon
        System.out.print("Nhap duong dan file nguon (Source File): ");
        String sourcePath = scanner.nextLine();
        File sourceFile = new File(sourcePath);

        // Canh bao 1: Kiem tra file nguon co ton tai hay khong
        if (!sourceFile.exists()) {
            System.out.println("[CANH BAO] Loi: File nguon khong ton tai! Ket thuc.");
            scanner.close();
            return;
        }
        if (sourceFile.isDirectory()) {
            System.out.println("[CANH BAO] Loi: Day la thu muc, khong phai tap tin! Ket thuc.");
            scanner.close();
            return;
        }

        // 2. Nhap duong dan file dich
        System.out.print("Nhap duong dan file dich (Target File): ");
        String targetPath = scanner.nextLine();
        File targetFile = new File(targetPath);

        // Canh bao 2: Kiem tra file dich da ton tai hay chua
        if (targetFile.exists()) {
            System.out.print("[CANH BAO] File dich da ton tai! Ban co muon ghi de khong? (Y/N): ");
            String confirm = scanner.nextLine().trim().toUpperCase();
            if (!confirm.equals("Y")) {
                System.out.println("-> Da huy thao tac sao chep theo yeu cau.");
                scanner.close();
                return;
            }
        }

        // 3. Tien hanh sao chep va dem so byte
        System.out.println("\nDang tien hanh sao chep...");
        long totalBytesCopied = 0;
        long startTime = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytesCopied += bytesRead;
            }

            long endTime = System.currentTimeMillis();

            // 4. Hien thi ket qua dau ra theo dung mo ta bai toan
            System.out.println("===============================================");
            System.out.println("[THANH CONG] Sao chep tap tin hoan tat!");
            System.out.println(" - Tong so byte trong tep da sao chep: " + totalBytesCopied + " bytes");
            System.out.println(" - Thoi gian xu ly: " + (endTime - startTime) + " ms");
            System.out.println("===============================================");

        } catch (IOException e) {
            System.err.println("[LOI] Co su co xay ra trong luc sao chep: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}