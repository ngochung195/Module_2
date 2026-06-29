class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    public Node front;
    public Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }
}

class Solution {
    public void enQueue(Queue queue, int value) {
        Node newNode = new Node(value);

        if (queue.front == null) {
            queue.front = newNode;
            queue.rear = newNode;
            queue.rear.next = queue.front;
        } else {
            queue.rear.next = newNode;
            queue.rear = newNode;
            queue.rear.next = queue.front;
        }
        System.out.println("Da them " + value + " vao hang doi");
    }

    public void deQueue(Queue queue) {
        if (queue.front == null) {
            System.out.println("Hang doi trong! Khong the lay phan tu.");
            return;
        }
        int deletedValue = queue.front.data;

        if (queue.front == queue.rear) {
            queue.front = null;
            queue.rear = null;
        } else {
            queue.front = queue.front.next;
            queue.rear.next = queue.front;
        }

        System.out.println("Da lay " + deletedValue + " ra khoi hang doi");
    }

    public void displayQueue(Queue queue) {
        if (queue.front == null) {
            System.out.println("Hang doi trong!");
            return;
        }

        System.out.println("Cac phan tu trong hang doi: ");
        Node temp = queue.front;

        do {
            System.out.println(temp.data + " ");
            temp = temp.next;
        } while (temp != queue.front);

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        Solution sol = new Solution();

        // 1. Thử nghiệm enQueue (Chèn phần tử)
        sol.enQueue(q, 10);
        sol.enQueue(q, 20);
        sol.enQueue(q, 30);
        sol.displayQueue(q); // Output: 10 20 30

        // 2. Thử nghiệm deQueue (Lấy phần tử ra)
        sol.deQueue(q); // Xóa 10
        sol.displayQueue(q); // Output: 20 30

        // 3. Chèn thêm phần tử mới để kiểm tra tính liên kết vòng
        sol.enQueue(q, 40);
        sol.displayQueue(q); // Output: 20 30 40

        // 4. Xóa hết các phần tử để kiểm tra điều kiện Front == Rear
        sol.deQueue(q); // Xóa 20
        sol.deQueue(q); // Xóa 30
        sol.deQueue(q); // Xóa 40 (Lúc này Front == Rear và hàng đợi về trống)
        sol.displayQueue(q); // Output: Hàng đợi trống.
    }
}