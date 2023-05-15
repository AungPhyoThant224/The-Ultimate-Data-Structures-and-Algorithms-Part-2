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

    public boolean isBalance(){
        return isBalance(root);
    }

    public boolean isPerfect(){
        var left = root.leftChild;
        var right = root.rightChild;
        
        var leftSize = size(left);
        var rightSize = size(right);

        if(left.height == right.height && leftSize == rightSize){
            return true;
        }
        return false;
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

        setHeight(root);

        return balance(root);
    }

    private AVLNode balance(AVLNode root){
        if(leftHeavy(root)){
            if(balanceFactor(root.leftChild) < 0){
                root.leftChild = rotateLeft(root.leftChild);
            }
            return rotateRight(root);
        }
        else if(rightHeavy(root)){
            if(balanceFactor(root.rightChild) > 0){
                root.rightChild = rotateRight(root.rightChild);
            }
            return rotateLeft(root);
        } 

        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        AVLNode newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        AVLNode newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node){
        node.height = Math.max(
            height(node.leftChild),
            height(node.rightChild)) + 1;
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

    private boolean isBalance(AVLNode root){
        if(root == null){
            return true;
        }

        if(balanceFactor(root) < -1 || balanceFactor(root) > 1){
            return false;
        }

        var left = isBalance(root.leftChild);
        var right = isBalance(root.rightChild);

        if(left == false || right == false){
            return false;
        }
        return true;
    }

    private int size(AVLNode node){
        if(node == null){
            return 0;
        }

        var left = size(node.leftChild);
        var right = size(node.rightChild);

        return left + right;
    }
}
