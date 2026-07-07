import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        BackupService backupService = new BackupService();

        // Dinh nghia cac file kiem thu
        String originalImg = "dummy_5mb_image.png";
        String backupSlow = "dummy_5mb_image_slow.png";
        String backupFast = "dummy_5mb_image_fast.png";

        System.out.println("=== KHOI TAO BAI KIEM THU SO SANH NANG SUAT ===");
        try {
            // Buoc 1: Tao file nhi phan dummy dung luong chinh xac 5MB
            System.out.print("Dang khoi tao file nhi phan dummy 5MB... ");
            createDummyBinaryFile(originalImg, 5 * 1024 * 1024);
            System.out.println("Xong.\n");

            // Buoc 2: Chay ham kiem thu toc do thap (Legacy)
            System.out.println("[TEST 1] Chay ham backupBinaryExtremelySlow:");
            backupService.backupBinaryExtremelySlow(originalImg, backupSlow);
            System.out.println();

            // Buoc 3: Chay ham kiem thu toc do cao (Refactored)
            System.out.println("[TEST 2] Chay ham backupBinaryFast:");
            backupService.backupBinaryFast(originalImg, backupFast);
            System.out.println();

            // Buoc 4: Kiem tra tinh toan ven cua du lieu sau khi copy
            System.out.println("=== KET LUAN & KIEM TRA DO CHINH XAC ===");
            File fOrig = new File(originalImg);
            File fSlow = new File(backupSlow);
            File fFast = new File(backupFast);

            System.out.println("Kiem tra kich thuoc file dau ra:");
            System.out.println(" - File goc ban dau       : " + fOrig.length() + " bytes");
            System.out.println(" - File sao chep (Slow)   : " + fSlow.length() + " bytes -> Trang thai: "
                    + (fOrig.length() == fSlow.length() ? "Khop hoan toan [OK]" : "Sai lech du lieu [FAIL]"));
            System.out.println(" - File sao chep (Fast)   : " + fFast.length() + " bytes -> Trang thai: "
                    + (fOrig.length() == fFast.length() ? "Khop hoan toan [OK]" : "Sai lech du lieu [FAIL]"));

        } catch (IOException e) {
            System.err.println("Loi moi truong test: " + e.getMessage());
        }
    }

    // Ham tao nhanh file dummy dung luong lon
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