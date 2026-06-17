package Bai3.phan_tu_max.src;

import java.util.Scanner;

public class TimMaxMaTran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- PHAN 1: MA TRAN CO SAN (KHOI TAO NHANH) ---");

        double[][] matrixAvailable = {
                { 1.2, 4.5, 3.8 },
                { 9.1, 5.5, 2.3 },
                { 7.6, 8.4, 0.9 }
        };

        double maxAvailable = matrixAvailable[0][0];
        int maxRowAvailable = 0;
        int maxColAvailable = 0;

        for (int i = 0; i < matrixAvailable.length; i++) {
            for (int j = 0; j < matrixAvailable[i].length; j++) {
                if (matrixAvailable[i][j] > maxAvailable) {
                    maxAvailable = matrixAvailable[i][j];
                    maxRowAvailable = i;
                    maxColAvailable = j;
                }
            }
        }

        System.out.println("Gia tri lon nhat trong ma tran co san: " + maxAvailable);
        System.out.println("Toa do: dong " + maxRowAvailable + ", cot " + maxColAvailable);
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

        double maxUser = matrixUser[0][0];
        int maxRowUser = 0;
        int maxColUser = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrixUser[i][j] > maxUser) {
                    maxUser = matrixUser[i][j];
                    maxRowUser = i;
                    maxColUser = j;
                }
            }
        }

        System.out.println("Gia tri lon nhat trong ma tran ban vua nhap: " + maxUser);
        System.out.println("Toa do: dong " + maxRowUser + ", cot " + maxColUser);

        scanner.close();
    }
}
