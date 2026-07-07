import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager("products.dat");
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MENU QUAN LY PHO PHONG ===");
            System.out.println("1. Them san pham moi");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Tim kiem san pham theo ten");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Vui long nhap lai mot so hop le: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- NHAP THONG TIN SAN PHAM MOI ---");
                    System.out.print("Nhap ma san pham: ");
                    String id = scanner.nextLine();

                    System.out.print("Nhap ten san pham: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhap gia san pham: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Gia phai la so thực, nhap lai: ");
                        scanner.next();
                    }
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Clear bo dem

                    System.out.print("Nhap hang san xuat: ");
                    String manufacturer = scanner.nextLine();

                    System.out.print("Nhap mo ta san pham: ");
                    String description = scanner.nextLine();

                    Product p = new Product(id, name, price, manufacturer, description);
                    manager.addProduct(p);
                    break;

                case 2:
                    manager.displayAllProducts();
                    break;

                case 3:
                    System.out.print("\nNhap ten san pham can tim kiem: ");
                    String keyword = scanner.nextLine();
                    manager.searchProductByName(keyword);
                    break;

                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh. Tam biet!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon tu 0 den 3.");
            }
        } while (choice != 0);

        scanner.close();
    }
}