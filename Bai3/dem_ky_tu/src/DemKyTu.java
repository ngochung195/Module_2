package Bai3.dem_ky_tu.src;

import java.util.Scanner;

public class DemKyTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "hoc lap trinh java rat vui va thu vi";
        System.out.println("Chuoi cho truoc: \"" + str + "\"");

        System.out.print("Nhap vao mot ky tu can dem: ");
        char ch = scanner.next().charAt(0);

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        System.out.println("So lan ky tu '" + ch + "' xuat hien trong chuoi la: " + count);

        scanner.close();
    }
}