public class Main{
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        // Tree tree1 = new Tree();
        // tree1.insert(7);
        // tree1.insert(4);
        // tree1.insert(9);
        // tree1.insert(1);
        // tree1.insert(6);
        // tree1.insert(8);
        // tree1.insert(10);

        // tree.swapRoot();
        // System.out.println(tree.isBinarySearchTree());
        // var list = tree.nodeAt(1);
        // System.out.println(list);
        // tree.traverseLevelOrder();

        // -------------Exercises---------------
        // System.out.println(tree.size());
        // tree.countLeaves();
        // System.out.println(tree.maxBinarySearch());
        // System.out.println(tree.contains(2));
        // System.out.println(tree.areSiblings(8, 10));
        tree.getAncestors(6);
    }
}