public class AVLTree {
    private class AVLNode{
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value){
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value){
        insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value){
        if(root == null){
            return new AVLNode(value);
        }

        if(value < root.value){
            root.leftChild = insert(root.leftChild, value);
        }
        else if(value > root.value){
            root.rightChild = insert(root.rightChild, value);
        }
        return root;
    }
}
