class MyLinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
        head = null;
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        if (index == 0) {
            addFirst(element);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            Node holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
        if (head == null) {
            addFirst(e);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(e);
            numNodes++;
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes || head == null) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        Node temp = head;
        Object data;

        if (index == 0) {
            data = head.data;
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
        }
        numNodes--;
        return (E) data;
    }

    public boolean remove(Object e) {
        if (head == null)
            return false;

        if (head.data.equals(e)) {
            head = head.next;
            numNodes--;
            return true;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(e)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public E get(int i) {
        if (i < 0 || i >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + numNodes);
        }
        Node temp = head;
        for (int index = 0; index < i; index++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        if (head == null)
            return null;
        return (E) head.data;
    }

    public E getLast() {
        if (head == null)
            return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public int size() {
        return this.numNodes;
    }

    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data.equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> clonedList = new MyLinkedList<>();
        Node temp = head;
        while (temp != null) {
            clonedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return clonedList;
    }
}

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("--- Khởi tạo danh sách ban đầu với phần tử đầu tiên ---");
        MyLinkedList<String> list = new MyLinkedList<>("Node_Gốc");
        list.printList();

        System.out.println("\n--- Thêm vào đầu và cuối ---");
        list.addFirst("Đầu_1");
        list.addLast("Cuối_1");
        list.addLast("Cuối_2");
        list.printList();

        System.out.println("\n--- Thêm vào vị trí index = 2 ---");
        list.add(2, "Giữa_Chèn");
        list.printList();

        System.out.println("\n--- Kiểm tra size và lấy phần tử ---");
        System.out.println("Kích thước hiện tại: " + list.size());
        System.out.println("Phần tử tại index 2: " + list.get(2));

        System.out.println("\n--- Tìm kiếm và kiểm tra tồn tại ---");
        System.out.println("Vị trí của 'Cuối_1': " + list.indexOf("Cuối_1"));
        System.out.println("Có chứa 'Không_Tồn_Tại' không?: " + list.contains("Không_Tồn_Tại"));

        System.out.println("\n--- Xóa phần tử theo index và theo Object ---");
        list.remove(0);
        System.out.print("Sau khi xóa tại index 0: ");
        list.printList();

        list.remove("Cuối_1");
        list.printList();

        System.out.println("\n--- Thử nghiệm clone danh sách ---");
        MyLinkedList<String> copiedList = list.clone();
        System.out.print("Danh sách được clone: ");
        copiedList.printList();
    }
}