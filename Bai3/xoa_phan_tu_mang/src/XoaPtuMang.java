package Bai3.xoa_phan_tu_mang.src;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPtuMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = { 10, 4, 6, 7, 8, 6, 9 };
        int N = array.length;

        System.out.println("Mảng ban đầu: " + Arrays.toString(array));

        System.out.print("Nhập phần tử x cần xoá: ");
        int x = scanner.nextInt();

        int index_del = -1;

        for (int i = 0; i < N; i++) {
            if (array[i] == x) {
                index_del = i;
                break;
            }
        }

        if (index_del == -1) {
            System.out.println("Phần tử " + x + " không tồn tại trong mảng.");
        } else {
            System.out.println("Tìm thấy " + x + " tại vị trí (index): " + index_del);

            for (int i = index_del; i < N - 1; i++) {
                array[i] = array[i + 1];
            }

            array[N - 1] = 0;

            System.out.print("Mảng sau khi xoá phần tử đầu tiên tìm thấy: ");
            System.out.println(Arrays.toString(array));
        }

        scanner.close();
    }

}
