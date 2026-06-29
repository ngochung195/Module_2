import java.util.Arrays;
import java.util.Stack;

public class ReverseArray {
    public static void reverseArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            stack.push(num);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        System.out.println("Mang ban dau: " + Arrays.toString(arr));

        reverseArray(arr);

        System.out.println("Mang sau khi dao nguoc: " + Arrays.toString(arr));
    }
}
