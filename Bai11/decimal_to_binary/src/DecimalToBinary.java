import java.util.Scanner;

// Sử dụng lại cấu trúc lớp MyStack từ bài trước
class MyStack {
    private int size;
    private int[] arr;
    private int index = 0;

    public MyStack(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public boolean isFull() {
        return index == size;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack đầy!");
        } else {
            arr[index] = element;
            index++;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            index--;
            return arr[index];
        }
    }
}

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thập phân cần chuyển đổi (ví dụ: 30): ");
        int decimalNumber = scanner.nextInt();

        int originalNumber = decimalNumber;

        MyStack stack = new MyStack(32);

        if (decimalNumber == 0) {
            stack.push(0);
        }

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            stack.push(remainder);
            decimalNumber = decimalNumber / 2;
        }

        StringBuilder binaryResult = new StringBuilder();
        while (!stack.isEmpty()) {
            binaryResult.append(stack.pop());
        }

        System.out.println("--- Kết quả toán học ---");
        System.out.println("Số thập phân: " + originalNumber);
        System.out.println("Số nhị phân (Binary): " + binaryResult.toString());

        scanner.close();
    }
}