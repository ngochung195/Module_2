package Bai3.chen_phan_tu.src;

import java.util.Arrays;
import java.util.Scanner;

public class ChenPhanTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = { 10, 4, 6, 7, 8, 9 };
        int N = array.length;
        System.out.println("Mang ban dau: " + Arrays.toString(array));

        System.out.print("Nhap so X can chen: ");
        int X = scanner.nextInt();

        System.out.print("Nhap vi tri index can chen (tu 0 den " + N + "): ");
        int index = scanner.nextInt();

        if (index < 0 || index > N) {
            System.out.println("Khong chen duoc phan tu vao mang. Vi tri khong hop le!");
        } else {

            int[] newArray = new int[N + 1];

            for (int i = 0; i < newArray.length; i++) {
                if (i < index) {
                    newArray[i] = array[i];
                } else if (i == index) {
                    newArray[i] = X;
                } else {
                    newArray[i] = array[i - 1];
                }
            }

            System.out.println("Mang sau khi chen: " + Arrays.toString(newArray));
        }

        scanner.close();
    }
}