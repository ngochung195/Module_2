import java.util.Scanner;
import java.util.Stack;

public class BracketChecker {
    public static boolean checkerBracket(String expression) {
        Stack<Character> bStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char sym = expression.charAt(i);

            if (sym == '(') {
                bStack.push(sym);
            } else {
                if (sym == ')') {
                    if (bStack.isEmpty()) {
                        return false;
                    }
                    bStack.pop();
                }
            }
        }
        return bStack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập biểu thức chỉ chứa ngoặc (): ");
        String input = scanner.nextLine();

        boolean result = checkerBracket(input);

        System.out.println("\n--- Kết quả kiểm tra ---");
        System.out.println("Biểu thức: " + input);
        if (result) {
            System.out.println("=> HỢP LỆ.");
        } else {
            System.out.println("=> KHÔNG HỢP LỆ.");
        }

        scanner.close();
    }
}