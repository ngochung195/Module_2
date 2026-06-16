import java.util.Scanner;

public class HienThiChao {
    public static void main(String[] args) {
        System.out.println("Nhập tên người dùng: ");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        System.out.println("Xin chào: " + name);
    }
}