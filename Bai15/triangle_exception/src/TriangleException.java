import java.util.Scanner;

public class TriangleException {
    public static class IllegalTriangleException extends RuntimeException {
        public IllegalTriangleException(String message) {
            super(message);
        }
    }

    public static void checkTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Loi: Cac canh cua tam giac phai la so duong");
        }

        if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
            throw new IllegalTriangleException("Loi: Tong 2 canh bat ky phai lon hon canh con lai");
        }

        System.out.println("Ba so (" + a + ", " + b + ", " + c + ") la 3 canh cua tam giac");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("KIEM TRA TAM GIAC");
        try {
            System.out.println("Nhap canh a: ");
            double a = scanner.nextDouble();

            System.out.println("Nhap canh b: ");
            double b = scanner.nextDouble();

            System.out.println("Nhap canh c: ");
            double c = scanner.nextDouble();

            checkTriangle(a, b, c);
        } catch (IllegalTriangleException e) {
            System.out.println("[XU LY LOI] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[XU LY LOI] Du lieu nhap vao phai la so!");
        } finally {
            scanner.close();
        }
    }
}
