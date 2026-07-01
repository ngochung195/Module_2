import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] list) {
        int pos, x;

        for (int i = 1; i < list.length; i++) {
            x = list[i];
            pos = i;

            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }

            list[pos] = x;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap so phan tu mang: ");
        int number = scanner.nextInt();

        int[] list = new int[number];

        System.out.println("Nhap cac phan tu mang: ");
        for (int i = 0; i < number; i++) {
            list[i] = scanner.nextInt();
        }

        insertionSort(list);

        System.out.print("Mang sau sap xep: ");
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
