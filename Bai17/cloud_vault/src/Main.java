import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileBackupService backupService = new FileBackupService();

        // Dinh nghia duong dan cac file dung de test
        String fileGoc = "dummy_50mb.dat";
        String fileCorrupted = "dest_corrupted.dat";
        String fileSlow = "dest_slow.dat";
        String fileOptimized = "dest_optimized.dat";

        // Thiet lap dung luong file gia: 50MB = 50 * 1024 * 1024 bytes
        int fileLength50MB = 50 * 1024 * 1024;

        System.out.println("=== BAT DAU MO PHONG VA KIEM THU HE THONG CLOUDVAULT ===");

        try {
            // BUOC 1: Tu dong tao file gia dung luong 50MB de test
            System.out.print("1. Dang sinh file nhi phan dummy 50MB... ");
            long startCreate = System.currentTimeMillis();
            createDummyBinaryFile(fileGoc, fileLength50MB);
            long endCreate = System.currentTimeMillis();
            System.out.println("Xong (Mat " + (endCreate - startCreate) + " ms).");
            System.out.println("---------------------------------------------------------");

            // BUOC 2: Test sao chep sai loai Stream (Hu hai du lieu)
            System.out.println("2. Chay ham copyCorrupted (Character Stream)...");
            backupService.copyCorrupted(fileGoc, fileCorrupted);
            System.out.println("-> Hoan thanh copy loi.");
            System.out.println("---------------------------------------------------------");

            // BUOC 3: Test sao chep tung byte (Tieu ton thoi gian)
            System.out.println("3. Chay ham copySlow (Byte Stream - Khong bo dem)...");
            System.out.println("   (Luu y: File 50MB copy tung byte co the mat tu 20 - 40 giay...)");
            long startSlow = System.currentTimeMillis();
            backupService.copySlow(fileGoc, fileSlow);
            long endSlow = System.currentTimeMillis();
            long timeSlow = endSlow - startSlow;
            System.out.println(
                    "-> Hoan thanh! Thoi gian copySlow: " + timeSlow + " ms (~" + (timeSlow / 1000) + " giay)");
            System.out.println("---------------------------------------------------------");

            // BUOC 4: Test sao chep toi uu bang mang dem (Sieu nhanh)
            System.out.println("4. Chay ham copyOptimized (Byte Stream + Bo dem 8KB)...");
            long startOptimized = System.currentTimeMillis();
            backupService.copyOptimized(fileGoc, fileOptimized);
            long endOptimized = System.currentTimeMillis();
            long timeOptimized = endOptimized - startOptimized;
            System.out.println("-> Hoan thanh! Thoi gian copyOptimized: " + timeOptimized + " ms");
            System.out.println("---------------------------------------------------------");

            // BUOC 5: Lay thong tin do luong o dia de lap bang thong ke so sanh
            System.out.println("=== KET LUAN KHAO SAT DUNG LUONG VA TOC DO ===");
            File fGoc = new File(fileGoc);
            File fCorrupted = new File(fileCorrupted);
            File fSlow = new File(fileSlow);
            File fOptimized = new File(fileOptimized);

            System.out.println("A. BANG SO SANH DUNG LUONG FILE:");
            System.out.println(" - File goc ban dau        : " + fGoc.length() + " bytes");
            System.out.println(" - File qua copySlow       : " + fSlow.length() + " bytes -> [AN TOAN]");
            System.out.println(" - File qua copyOptimized  : " + fOptimized.length() + " bytes -> [AN TOAN]");
            System.out.println(" - File qua copyCorrupted  : " + fCorrupted.length() + " bytes");

            System.out.println("\n>> Nhan xet ve copyCorrupted:");
            if (fGoc.length() != fCorrupted.length()) {
                System.out.println("   [!] Kich thuoc BI BIEN DOI (Sai lech "
                        + Math.abs(fGoc.length() - fCorrupted.length()) + " bytes).");
                System.out.println(
                        "   [!] Giai thich: FileReader ep dich sai ma hex khien file bi sai thong tin va phinh to dung luong.");
            }

            System.out.println("\nB. TI LE TOI UU TOC DO:");
            double thoiGianChenhLech = (double) timeSlow / timeOptimized;
            System.out.printf("   -> copyOptimized nhanh gap %.2f lan so voi copySlow!%n", thoiGianChenhLech);

        } catch (IOException e) {
            System.err.println("Co loi xay ra trong qua trinh kiem thu: " + e.getMessage());
        }
    }

    // Ham ho tro khoi tao nhanh file nhi phan 50MB bang cach ghi block tap trung
    private static void createDummyBinaryFile(String fileName, int sizeInBytes) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] data = new byte[8192];
            int written = 0;
            while (written < sizeInBytes) {
                int toWrite = Math.min(data.length, sizeInBytes - written);
                fos.write(data, 0, toWrite);
                written += toWrite;
            }
        }
    }
}