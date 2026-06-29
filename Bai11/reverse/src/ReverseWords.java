import java.util.Stack;

public class ReverseWords {
    public static String reverseWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return input;
        }

        Stack<String> wStack = new Stack<>();

        String[] words = input.split("\\s+");

        for (String mWords : words) {
            wStack.push(mWords);
        }

        StringBuilder outp = new StringBuilder();
        while (!wStack.isEmpty()) {
            String mWord = wStack.pop();
            outp.append(mWord).append(" ");
        }

        return outp.toString().trim();
    }

    public static void main(String[] args) {
        String input = "Hoc lap trinh tai CodeGym";

        System.out.println("Chuoi ban dau: " + input);

        String result = reverseWords(input);

        System.out.println("Chuoi sau khi dao nguoc: " + result);
    }
}
