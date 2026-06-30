public class BinarySearchTree {
    // Giả sử cấu trúc Node đã được định nghĩa trước đó
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // --- PHƯƠNG THỨC XÓA PHẦN TỬ ---
    public boolean delete(int e) {
        // Bước 1: Xác định vị trí của phần tử e và nút cha của nó
        Node parent = null;
        Node current = root;

        while (current != null) {
            if (e < current.data) {
                parent = current;
                current = current.left;
            } else if (e > current.data) {
                parent = current;
                current = current.right;
            } else {
                break; // Đã tìm thấy phần tử e tại nút 'current'
            }
        }

        // Nếu không tìm thấy phần tử e trong cây, trả về false
        if (current == null) {
            return false;
        }

        // TRƯỜNG HỢP 1: Nút hiện tại không có con bên trái (current has no left child)
        if (current.left == null) {
            // Nếu nút cần xóa là nút gốc (gốc không có cha)
            if (parent == null) {
                root = current.right;
            } else {
                // Kết nối nút cha trực tiếp với nút con bên phải của current
                if (e < parent.data) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        }
        // TRƯỜNG HỢP 2: Nút hiện tại có con bên trái (current has a left child)
        else {
            // Tìm nút phải cùng (rightMost) thuộc cây con bên trái của current
            Node parentOfRightMost = current;
            Node rightMost = current.left;

            // Dịch chuyển về tận cùng bên phải của cây con trái
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Đi tiếp sang phải
            }

            // Thay thế giá trị của nút current bằng giá trị của nút rightMost
            current.data = rightMost.data;

            // Kết nối nút cha của rightMost với nút con bên trái của rightMost
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else {
                // Trường hợp đặc biệt: Nút con bên trái của current chính là rightMost luôn
                parentOfRightMost.left = rightMost.left;
            }
        }

        return true; // Xóa thành công
    }

    // Các phương thức phụ trợ để test chương trình
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
}