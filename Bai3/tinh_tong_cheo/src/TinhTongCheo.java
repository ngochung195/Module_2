package Bai3.tinh_tong_cheo.src;

import java.util.Scanner;

public class TinhTongCheo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- PHAN 1: MA TRAN CO SAN (KHOI TAO NHANH) ---");

        int[][] matrixAvailable = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Ma tran co san hien tai:");
        for (int i = 0; i < matrixAvailable.length; i++) {
            for (int j = 0; j < matrixAvailable[i].length; j++) {
                System.out.print(matrixAvailable[i][j] + "\t");
            }
            System.out.println();
        }

        int sumAvailable = 0;
        for (int i = 0; i < matrixAvailable.length; i++) {
            sumAvailable += matrixAvailable[i][i];
        }

        System.out.println("Tong cac phan tu tren duong cheo chinh (co san) la: " + sumAvailable);
        System.out.println();

        System.out.println("--- PHAN 2: MA TRAN VUONG NHAP TU BAN PHIM ---");

        System.out.print("Nhap kich thuoc N cua ma tran vuong (N x N): ");
        int n = scanner.nextInt();

        int[][] matrixUser = new int[n][n];

        System.out.println("Nhap cac phan tu cho ma tran:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Matrix[" + i + "][" + j + "] = ");
                matrixUser[i][j] = scanner.nextInt();
            }
        }

        int sumUser = 0;
        for (int i = 0; i < n; i++) {
            sumUser += matrixUser[i][i];
        }

        System.out.println("Tong cac phan tu tren duong cheo chinh (ban nhap) la: " + sumUser);

        scanner.close();
    }
}
