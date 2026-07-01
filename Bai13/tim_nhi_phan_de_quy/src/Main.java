package com.codegym;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu [" + i + "]: ");
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);
        System.out.println("Mang sau khi sap xep tang dan: " + Arrays.toString(array));

        System.out.print("Nhap gia tri can tim: ");
        int value = scanner.nextInt();

        int resultIndex = binarySearch(array, 0, array.length - 1, value);

        if (resultIndex != -1) {
            System.out.println("Tim thay gia tri " + value + " tai vi tri: " + resultIndex);
        } else {
            System.out.println("Khong tim thay gia tri " + value + " trong mang.");
        }
    }

    public static int binarySearch(int[] array, int left, int right, int value) {

        while (left <= right) {

            int middle = (left + right) / 2;

            if (array[middle] == value) {
                return middle;
            }

            if (value > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}