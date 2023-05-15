public class AVLTree {
    private class AVLNode{
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value){
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value){
        root = insert(root, value);
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

        root.height = Math.max(height(root.leftChild), height(root.rightChild)) +1;

        balance(root);
        return root;
    }

    private void balance(AVLNode root){
        if(leftHeavy(root)){
            if(balanceFactor(root.leftChild) < 0){
                System.out.println("Left rotate " + (root.leftChild.value));
            }
            System.out.println("Right rotate " + (root.value));
        }
        else if(rightHeavy(root)){
            if(balanceFactor(root.rightChild) > 0){
                System.out.println("Right rotate " + (root.rightChild.value));
            }
            System.out.println("Left rotate " + (root.value));
        } 
    }

    private int height(AVLNode root){
        return (root == null) ? -1 : root.height;
    }

    private boolean leftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }

    private boolean rightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node){
        return (root == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

}
