import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Them san vai du lieu mau de test cho nhanh
        manager.addProduct(new Product(1, "iPhone 15", 22000000));
        manager.addProduct(new Product(2, "Samsung S24", 21000000));
        manager.addProduct(new Product(3, "MacBook Air", 26000000));

        do {
            System.out.println("\n===== MENU QUAN LY SAN PHAM =====");
            System.out.println("1. Hien thi danh sach san pham");
            System.out.println("2. Them san pham moi");
            System.out.println("3. Sua thong tin san pham theo ID");
            System.out.println("4. Xoa san pham theo ID");
            System.out.println("5. Tim kiem san pham theo ten");
            System.out.println("6. Sap xep san pham theo gia TANG DAN");
            System.out.println("7. Sap xep san pham theo gia GIAM DAN");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Xoa bo nho dem (tranh loi troi lenh)

            switch (choice) {
                case 1:
                    manager.displayProducts();
                    break;
                case 2:
                    System.out.print("Nhap ID san pham: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhap ten san pham: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhap gia san pham: ");
                    double price = scanner.nextDouble();

                    manager.addProduct(new Product(id, name, price));
                    break;
                case 3:
                    System.out.print("Nhap ID san pham can sua: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhap ten moi: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nhap gia moi: ");
                    double newPrice = scanner.nextDouble();

                    if (manager.editProduct(editId, newName, newPrice)) {
                        System.out.println("Cap nhat thanh cong!");
                    } else {
                        System.out.println("Khong tim thay san pham co ID = " + editId);
                    }
                    break;
                case 4:
                    System.out.print("Nhap ID san pham can xoa: ");
                    int delId = scanner.nextInt();
                    if (manager.deleteProduct(delId)) {
                        System.out.println("Xoa san pham thanh cong!");
                    } else {
                        System.out.println("Khong tim thay san pham co ID = " + delId);
                    }
                    break;
                case 5:
                    System.out.print("Nhap ten san pham can tim: ");
                    String searchName = scanner.nextLine();
                    manager.searchProductByName(searchName);
                    break;
                case 6:
                    manager.sortPriceAscending();
                    manager.displayProducts();
                    break;
                case 7:
                    manager.sortPriceDescending();
                    manager.displayProducts();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (choice != 0);

        scanner.close();
    }
}