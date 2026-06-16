package Bai2.in_snt.src;

public class InSoNto {
    public static void main(String[] args) {
        System.out.println("Cac so nguyen to trong khoang tu 2 den 100 la:");

        for (int i = 2; i <= 100; i++) {

            boolean laSoNguyenTo = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    laSoNguyenTo = false;
                    break;
                }
            }

            if (laSoNguyenTo) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}