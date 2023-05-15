public class Main{
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);

        // ----------Exercises-------------
        // System.out.println(tree.isBalance());
        System.out.println(tree.isPerfect());
    }
}