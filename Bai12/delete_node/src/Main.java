public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Xây dựng cây mẫu để test
        tree.insert(20);
        tree.insert(10);
        tree.insert(35);
        tree.insert(14);
        tree.insert(31);
        tree.insert(42);
        tree.insert(16);

        System.out.print("Cay ban dau (Duyet Inorder): ");
        tree.inorder(); // Kết quả: 10 14 16 20 31 35 42

        // 1. Test trường hợp 1: Xóa nút 10 (Nút không có con trái, chỉ có con phải là
        // 14)
        System.out.println("\n--- Xoa nut 10 (Truong hop 1) ---");
        if (tree.delete(10)) {
            System.out.print("Cay sau khi xoa 10: ");
            tree.inorder(); // Kết quả mong đợi: 14 16 20 31 35 42
        }

        // 2. Test trường hợp nút lá: Xóa nút 16 (Nút lá cũng rơi vào trường hợp 1 với
        // con phải = null)
        System.out.println("\n--- Xoa nut 16 (Nut la - Truong hop 1) ---");
        if (tree.delete(16)) {
            System.out.print("Cay sau khi xoa 16: ");
            tree.inorder(); // Kết quả mong đợi: 14 20 31 35 42
        }

        // 3. Test trường hợp 2: Xóa nút gốc 20 (Nút có cả con trái và con phải)
        // Lúc này rightMost của cây con trái (đầu gốc là 14) sẽ là nút 14.
        System.out.println("\n--- Xoa nut goc 20 (Truong hop 2) ---");
        if (tree.delete(20)) {
            System.out.print("Cay sau khi xoa 20: ");
            tree.inorder(); // Kết quả mong đợi: 14 31 35 42
        }
    }
}