class Node {
    int data;
    Node left;
    Node right;

    public Node(int date) {
        this.data = date;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void postOrderTraversal() {
        postOrder(root);
        System.out.println();
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);

        postOrder(node.right);

        System.out.println(node.data + " ");
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Chen cac phan tu vao cay giong nhu cay minh hoa ben tren
        tree.insert(27);
        tree.insert(14);
        tree.insert(35);
        tree.insert(10);
        tree.insert(19);
        tree.insert(31);
        tree.insert(42);

        // Chay va kiem tra ket qua duyet Post-order
        System.out.print("Ket qua duyet cay theo thu tu Post-order: ");
        tree.postOrderTraversal();
    }
}