import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("=== CHƯƠNG TRÌNH GIẢI PHƯƠNG TRÌNH BẬC NHẤT ===");
        System.out.println("Phương trình có dạng: a * x + b = 0");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập hằng số a: ");
        double a = scanner.nextDouble();

        System.out.print("Nhập hằng số b: ");
        double b = scanner.nextDouble();

        if (a != 0) {
            double solution = -b / a;
            System.out.printf("Phương trình có nghiệm duy nhất: x = %f\n", solution);
        } else {
            if (b == 0) {
                System.out.println("Phương trình có vô số nghiệm!");
            } else {
                System.out.println("Phương trình vô nghiệm!");
            }
        }
    }
}