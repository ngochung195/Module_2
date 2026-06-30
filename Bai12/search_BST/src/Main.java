public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(27);
        tree.insert(14);
        tree.insert(35);
        tree.insert(10);
        tree.insert(19);
        tree.insert(31);
        tree.insert(42);

        int target1 = 19;
        if (tree.search(target1)) {
            System.out.println("Tim thay phan tu " + target1 + " trong cay.");
        } else {
            System.out.println("Khong tim thay phan tu " + target1 + " trong cay.");
        }

        int target2 = 99;
        if (tree.search(target2)) {
            System.out.println("Tim thay phan tu " + target2 + " trong cay.");
        } else {
            System.out.println("Khong tim thay phan tu " + target2 + " trong cay.");
        }
    }
}