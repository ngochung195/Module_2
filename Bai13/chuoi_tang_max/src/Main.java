import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chuoi: ");
        String input = scanner.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();

            list.add(input.charAt(i));

            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(j) > list.getLast()) {
                    list.add(input.charAt(j));
                }
            }

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }

            list.clear();
        }

        for (Character ch : max) {
            System.out.print(ch);
        }
    }
}
/********************************************
 * 
 * Tính toán độ phức tạp của bài toán: *
 * 
 * 1 vòng lặp bên ngoài = n; *
 * 
 * 1 vòng lặp bên trong = n - 1; *
 * 
 * 1 câu lệnh = 1 *
 * 
 * 1 vòng lặp * 1 câu lệnh = 1; *
 * 
 * T(n) = (n * (n - 1)) + (1 + 1); *
 * 
 * T(n) = O(n^2) + O(n); *
 * 
 * T(n) = O(n^2); *
 * 
 * => Độ phức tạp bài toán này là O(n^2) *
 * 
 *******************************************/