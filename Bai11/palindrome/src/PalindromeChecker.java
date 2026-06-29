import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String inputString = scanner.nextLine();

        String cleanedString = inputString.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < cleanedString.length(); i++) {
            char ch = cleanedString.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;
        while (!stack.isEmpty()) {
            char fromStack = stack.pop();
            char fromQueue = queue.remove();

            if (fromStack != fromQueue) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("\n--- Kết quả kiểm tra ---");
        System.out.println("Chuỗi ban đầu: \"" + inputString + "\"");
        if (isPalindrome) {
            System.out.println("=> ĐÂY LÀ CHUỖI PALINDROME.");
        } else {
            System.out.println("=> ĐÂY KHÔNG PHẢI CHUỖI PALINDROME.");
        }

        scanner.close();
    }
}