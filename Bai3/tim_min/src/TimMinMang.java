package Bai3.tim_min.src;

import java.util.Arrays;
import java.util.Scanner;

public class TimMinMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap kich thuoc mang (size): ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Nhap cac phan tu cho mang:");
        for (int i = 0; i < size; i++) {
            System.out.print("array[" + i + "] = ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Mang vua nhap: " + Arrays.toString(array));

        int min = array[0];
        int indexMin = 0;

        for (int i = 1; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
                indexMin = i;
            }
        }

        System.out.println("Gia tri nho nhat trong mang la: " + min);
        System.out.println("Vi tri (index) cua gia tri nho nhat la: " + indexMin);

        scanner.close();
    }
}