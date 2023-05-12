import java.util.ArrayList;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }

        // @Override
        // public String toString(){
        //     return "Node" + value;
        // }
    }

    private Node root;
    private int count;

    public void insert(int value){
        var node = new Node(value);

        if(root == null){
            root = node;
            return;
        }

        var current = root;
        while(true){

            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else if(value > current.value){
                if(current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
            else{
                break;
            }
        }
    }
    
    public boolean find(int value){
        var current = root;
        while(current != null){
            if(value < current.value){
                current = current.leftChild;
            }
            else if(value > current.value){
                current = current.rightChild;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public void traverseLevelOrder(){
        for(int i = 0; i <= height(root); i++){
            var list = nodeAt(i);
            for(var item : list){
                System.out.println(item);
            }
        }
    }

    public int height(){
        return height(root);
    }

    // O(log n)
    public int minBinarySearch(){
        if(root == null){
            throw new IllegalStateException();
        }

        var current = root;
        var last = current;
        while(current != null){
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    public int min(){
        return min(root);
    }

    public boolean equal(Tree other){
        if(other.root == null){
            return false;
        }

        return equal(root, other.root);
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void swapRoot(){
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public ArrayList<Integer> nodeAt(int k){
        ArrayList<Integer> list = new ArrayList<>();
        nodeAt(root, k, list);
        return list;
    }

    private void nodeAt(Node root, int k, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        if(k == 0){
            list.add(root.value);
            return;
        }

        nodeAt(root.leftChild, k - 1, list);    
        nodeAt(root.rightChild, k - 1, list);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.value < min || root.value > max){
            return false;
        }

        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
            isBinarySearchTree(root.rightChild, root.value+1, max);
    }

    private boolean equal(Node first, Node second){
        if(first == null && second == null){
            return true;
        }
        
        if(first != null && second != null){
            var left = equal(first.leftChild, second.leftChild);
            var right = equal(first.rightChild, second.rightChild);
            return first.value == second.value && left && right;
        }

        return false;
    }

    //O(n)
    private int min(Node root){
        if(isLeaf(root)){
            return root.value;
        }

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private int height(Node root){
        if(isLeaf(root)){
            return 0; 
        }

        return 1 + Math.max(
            height(root.leftChild), 
            height(root.rightChild));
    }

    private boolean isLeaf(Node root){
        return root.leftChild == null && root.rightChild == null;
    }

    private void traversePreOrder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root){
        if(root == null){
            return;
        }

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root){
        if(root == null){
            return;
        }

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
}
