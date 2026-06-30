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

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void preOrderTraversal() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        preOrder(node.left);

        preOrder(node.right);
    }
}

public class MainPreorderBST {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(27);

        tree.insert(14);
        tree.insert(35);

        tree.insert(10);
        tree.insert(19);

        tree.insert(31);
        tree.insert(42);

        System.out.print("Ket qua duyet cay theo thu tu Pre-order: ");
        tree.preOrderTraversal();
    }
}