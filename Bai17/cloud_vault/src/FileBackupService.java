import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * HE THONG CLOUDVAULT (REFACTORED)
 */
public class FileBackupService {

    private static final int BUFFER_SIZE = 8192; // 8KB

    /**
     * LOI 1: Dung Text Stream de copy moi loai file.
     * Se lam bien doi bang ma khien file nhi phan (.png, .mp4, .zip) bi hong hoàn
     * toan.
     */
    public void copyCorrupted(String sourcePath, String destPath) throws IOException {
        try (FileReader reader = new FileReader(sourcePath);
                FileWriter writer = new FileWriter(destPath)) {
            int data;
            while ((data = reader.read()) != -1) {
                writer.write(data);
            }
        }
    }

    /**
     * LOI 2: Dung dung Byte Stream nhung doc/ghi TUNG BYTE MOT.
     * Gay ton rat nhieu thao tac Disk I/O khien toc do bi cham keo dai.
     */
    public void copySlow(String sourcePath, String destPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourcePath);
                FileOutputStream fos = new FileOutputStream(destPath)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        }
    }

    /**
     * GIAI PHAP TOI UU: Su dung Byte Stream ket hop mang byte dem (Buffer 8KB).
     * Cho toc do sao chep sieu nhanh va an toan cho moi dinh dang file thon.
     */
    public void copyOptimized(String sourcePath, String destPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourcePath);
                FileOutputStream fos = new FileOutputStream(destPath)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}