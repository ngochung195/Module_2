package Bai2.ve_hinh.src;

import java.util.Scanner;

public class VeHinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== MENU QUAN LY IN HINH =====");
            System.out.println("1. In hinh chu nhat");
            System.out.println("2. In hinh tam giac vuong (Bottom-Left)");
            System.out.println("3. In hinh tam giac vuong (Top-Left)");
            System.out.println("4. In hinh tam giac can");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap chieu dai (so cot): ");
                    int chieuDai = input.nextInt();
                    System.out.print("Nhap chieu rong (so dong): ");
                    int chieuRong = input.nextInt();

                    System.out.println("\nKet qua:");
                    for (int i = 1; i <= chieuRong; i++) {
                        for (int j = 1; j <= chieuDai; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.print("Nhap chieu cao tam giac: ");
                    int h2 = input.nextInt();

                    System.out.println("\nKet qua:");
                    for (int i = 1; i <= h2; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.print("Nhap chieu cao tam giac: ");
                    int h3 = input.nextInt();

                    System.out.println("\nKet qua:");
                    for (int i = h3; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.print("Nhap chieu cao tam giac can: ");
                    int h4 = input.nextInt();

                    System.out.println("\nKet qua:");
                    for (int i = 1; i <= h4; i++) {
                        for (int j = 1; j <= h4 - i; j++) {
                            System.out.print("  ");
                        }
                        for (int k = 1; k <= (2 * i - 1); k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 0:
                    System.out.println("Tam biet! Chuong trinh ket thuc.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        }
        input.close();
    }
}
