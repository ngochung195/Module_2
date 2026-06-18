package Bai4.StopWatch.src;

import java.util.Random;

public class Main {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        final int SIZE = 100000;
        int[] numbers = new int[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            numbers[i] = random.nextInt(100000);
        }

        StopWatch stopWatch = new StopWatch();

        System.out.println("Dang bat dau sap xep 100,000 phan tu...");
        stopWatch.start();

        selectionSort(numbers);

        stopWatch.stop();

        System.out.println("Sap xep hoan thanh!");
        System.out.println("Thoi gian thuc thi: " + stopWatch.getElapsedTime() + " mili-giay.");
    }
}