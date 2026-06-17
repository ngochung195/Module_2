package Bai3.tinh_tong_cot.src;

import java.util.Scanner;

public class TinhTongCot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- PHAN 1: MA TRAN CO SAN (KHOI TAO NHANH) ---");

        double[][] matrixAvailable = {
                { 1.5, 2.0, 3.5 },
                { 4.0, 5.5, 6.0 },
                { 7.5, 8.0, 9.5 }
        };

        System.out.println("Ma tran co san hien tai:");
        for (int i = 0; i < matrixAvailable.length; i++) {
            for (int j = 0; j < matrixAvailable[i].length; j++) {
                System.out.print(matrixAvailable[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("Nhap so cot ban muon tinh tong (tu 0 den " + (matrixAvailable[0].length - 1) + "): ");
        int colChoice1 = scanner.nextInt();

        if (colChoice1 < 0 || colChoice1 >= matrixAvailable[0].length) {
            System.out.println("So cot khong hop le!");
        } else {
            double sum1 = 0;
            for (int i = 0; i < matrixAvailable.length; i++) {
                sum1 += matrixAvailable[i][colChoice1];
            }
            System.out.println("Tong cac phan tu cua cot " + colChoice1 + " la: " + sum1);
        }
        System.out.println();

        System.out.println("--- PHAN 2: MA TRAN NHAP TU BAN PHIM ---");

        System.out.print("Nhap so dong cua ma tran: ");
        int rows = scanner.nextInt();
        System.out.print("Nhap so cot cua ma tran: ");
        int cols = scanner.nextInt();

        double[][] matrixUser = new double[rows][cols];

        System.out.println("Nhap cac phan tu cho ma tran:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Matrix[" + i + "][" + j + "] = ");
                matrixUser[i][j] = scanner.nextDouble();
            }
        }

        System.out.print("Nhap so cot ban muon tinh tong (tu 0 den " + (cols - 1) + "): ");
        int colChoice2 = scanner.nextInt();

        if (colChoice2 < 0 || colChoice2 >= cols) {
            System.out.println("So cot khong hop le!");
        } else {
            double sum2 = 0;
            for (int i = 0; i < rows; i++) {
                sum2 += matrixUser[i][colChoice2];
            }
            System.out.println("Tong cac phan tu cua cot " + colChoice2 + " trong ma tran ban nhap la: " + sum2);
        }

        scanner.close();
    }
}