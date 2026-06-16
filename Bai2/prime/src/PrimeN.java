import java.util.Scanner;

public class PrimeN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhap so luong so nguyen to can in ra (numbers): ");
        int numbers = input.nextInt();

        int count = 0;

        int N = 2;

        System.out.println("\nKet qua " + numbers + " so nguyen to dau tien la:");

        while (count < numbers) {

            boolean laSoNguyenTo = true;

            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    laSoNguyenTo = false;
                    break;
                }
            }

            if (laSoNguyenTo) {
                System.out.print(N + " ");
                count++;
            }

            N++;
        }

        System.out.println();
        input.close();
    }
}