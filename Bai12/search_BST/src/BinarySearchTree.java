public class BinarySearchTree {
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

    public boolean search(int element) {
        Node current = root;

        while (current != null) {
            if (element < current.data) {
                current = current.left;
            } else if (element > current.data) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

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
}