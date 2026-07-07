import java.io.*;

public class BackupService {
    private static final int BUFFER_SIZE = 8192;

    public void backupBinaryExtremelySlow(String source, String dest) {
        try (FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(dest)) {

            System.out.println("-> [Slow] Bắt đầu copy từng byte...");
            long startTime = System.currentTimeMillis();

            int byteData;
            // Gọi ổ cứng liên tục cho MỖI byte dữ liệu
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("-> [Slow] Hoàn thành! Thời gian (Không Buffer): " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }

    public void backupBinaryFast(String source, String dest) {
        try (FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(dest)) {

            System.out.println("-> [Fast] Bắt đầu copy với mảng byte đệm...");
            long startTime = System.currentTimeMillis();

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            // Nạp một lúc 8192 byte vào bộ nhớ đệm
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("-> [Fast] Hoàn thành! Thời gian (Có Buffer): " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}