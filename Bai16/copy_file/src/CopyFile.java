import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhận đường dẫn từ người dùng
        System.out.print("Nhap duong dan file nguon (Source file): ");
        String sourcePath = scanner.nextLine();

        System.out.print("Nhap duong dan file dich (Target file): ");
        String targetPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        // 2. Kiểm tra các điều kiện ràng buộc
        if (!sourceFile.exists()) {
            System.out.println("Canh bao: File nguon khong ton tai!");
            return; // Dừng chương trình
        }

        if (targetFile.exists()) {
            System.out.println("Canh bao: File dich da ton tai! Khong the ghi de.");
            return; // Dừng chương trình để bảo vệ dữ liệu cũ
        }

        // 3. Tiến hành sao chép file bằng Luồng Byte (Stream)
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int byteCount = 0;

        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);

            int data;
            // Đọc từng byte từ file nguồn cho đến khi hết file (-1)
            while ((data = fis.read()) != -1) {
                fos.write(data); // Ghi byte đó vào file đích
                byteCount++; // Tăng biến đếm ký tự (byte)
            }

            System.out.println("--- Sao chep thanh cong ---");
            System.out.println("So ky tu (bytes) da sao chep: " + byteCount);

        } catch (IOException e) {
            System.out.println("Co loi xay ra trong qua trinh sao chep: " + e.getMessage());
        } finally {
            // 4. Đóng các luồng dữ liệu để giải phóng bộ nhớ
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                System.out.println("Loi khi dong luong: " + e.getMessage());
            }
        }
    }
}