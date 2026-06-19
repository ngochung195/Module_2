/**
 * HỆ THỐNG NGÂN HÀNG - BUGBANK (LEGACY CODE)
 */

package Bai5.bug_bank.src;

class BankAccount {
    private String ownerName;

    private double balance;

    private static double interestRate = 0.05;
    static int totalAccounts = 0;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;

        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0!");
        }
    }

    public static void updateInterestRate(double newRate) {
        interestRate = newRate;
        System.out.println("\n[Hệ thống] Lãi suất toàn ngân hàng đã được cập nhật thành: " + (newRate * 100) + "%");
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }
}

public class MainBank {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice");
        BankAccount acc2 = new BankAccount("Bob");

        acc1.deposit(1000);
        acc2.deposit(500);

        System.out.println("=== KIỂM TRA SỐ LƯỢNG TÀI KHOẢN ===");
        System.out.println("Tổng số tài khoản trong hệ thống: " + BankAccount.totalAccounts);

        System.out.println("\n=== LÃI SUẤT BAN ĐẦU ===");
        System.out.println("Lãi suất tài khoản Alice: " + (acc1.getInterestRate() * 100) + "%");
        System.out.println("Lãi suất tài khoản Bob: " + (acc2.getInterestRate() * 100) + "%");

        BankAccount.updateInterestRate(0.07);

        System.out.println("\n=== LÃI SUẤT SAU KHI CẬP NHẬT ===");
        System.out.println("Lãi suất tài khoản Alice: " + (acc1.getInterestRate() * 100) + "%");
        System.out.println("Lãi suất tài khoản Bob: " + (acc2.getInterestRate() * 100) + "%");
    }
}