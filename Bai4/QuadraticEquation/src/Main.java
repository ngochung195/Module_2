package Bai4.QuadraticEquation.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Invalid input! 'a' cannot be zero for a quadratic equation.");
        } else {
            QuadraticEquation equation = new QuadraticEquation(a, b, c);
            double delta = equation.getDiscriminant();

            if (delta > 0) {
                System.out.printf("The equation has two roots: %.5f and %.5f\n",
                        equation.getRoot1(), equation.getRoot2());
            } else if (delta == 0) {
                System.out.printf("The equation has one root: %.5f\n",
                        equation.getRoot1());
            } else {
                System.out.println("The equation has no roots");
            }
        }

        scanner.close();
    }
}