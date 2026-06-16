import java.util.Scanner;

public class ChuyenDoiTien {
    public static void main(String[] args) {
        int rate = 23000;

        System.out.println("Nhap so tien muon doi (USD): ");
        Scanner scanner = new Scanner(System.in);
        double usd = scanner.nextDouble();

        double vnd = usd * rate;

        System.out.println(usd + " USD chuyen doi thanh " + vnd + " VND");

        scanner.close();
    }
}
