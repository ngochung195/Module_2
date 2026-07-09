public class ReportGenerator {

    // --- PHUONG THUC CU (LEGACY) ---
    public void generateReportLegacy(int records) {
        System.out.println("--- Bat dau sinh bao cao voi String (Legacy) ---");

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Yeu cau don rac truoc khi do
        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.currentTimeMillis();

        String csvReport = "TransactionID,Amount,Status\n";

        // Vong lap tu than gay bung no bo nho
        for (int i = 0; i < records; i++) {
            csvReport += "TXN" + i + ",500000,SUCCESS\n";
        }

        long endTime = System.currentTimeMillis();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Thoi gian chay (String): " + (endTime - startTime) + " ms");
        System.out.println("RAM tieu thu (uoc tinh): " + ((endMemory - startMemory) / (1024 * 1024)) + " MB\n");
    }

    // --- PHUONG THUC TOI UU (OPTIMIZED) ---
    public void generateReportOptimized(int records) {
        System.out.println("--- Bat dau sinh bao cao voi StringBuilder (Optimized) ---");

        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Yeu cau don rac truoc khi do
        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.currentTimeMillis();

        // Khoi tao StringBuilder
        StringBuilder sb = new StringBuilder("TransactionID,Amount,Status\n");

        for (int i = 0; i < records; i++) {
            sb.append("TXN").append(i).append(",500000,SUCCESS\n");
        }

        String finalReport = sb.toString();

        long endTime = System.currentTimeMillis();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Thoi gian chay (StringBuilder): " + (endTime - startTime) + " ms");
        System.out.println("RAM tieu thu (uoc tinh): " + ((endMemory - startMemory) / (1024 * 1024)) + " MB\n");
    }

    public static void main(String[] args) {
        ReportGenerator generator = new ReportGenerator();
        int records = 100000;

        generator.generateReportLegacy(records);

        System.out.println("Dang kich hoat GC de don dep RAM truoc khi chay test tiep theo...\n");
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        generator.generateReportOptimized(records);
    }
}