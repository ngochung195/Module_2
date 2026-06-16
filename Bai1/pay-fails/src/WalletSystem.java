public class WalletSystem {
    public static void main(String[] args) {

        System.out.println("--- GIAO DỊCH NẠP TIỀN ---");
        long currentBalance = 2147000000;
        long depositAmount = 1000000;

        long newBalance = currentBalance + depositAmount;
        System.out.println("Số dư sau khi nạp: " + newBalance + " VNĐ");

        System.out.println("\n--- THỐNG KÊ CHI TIÊU ---");
        long totalSpent = 0;
        long transactionCount = 0;

        double averageSpent = (transactionCount > 0) ? ((double) totalSpent / transactionCount) : 0;
        System.out.println("Chi tiêu trung bình mỗi giao dịch: " + averageSpent + " VNĐ");
    }
}
