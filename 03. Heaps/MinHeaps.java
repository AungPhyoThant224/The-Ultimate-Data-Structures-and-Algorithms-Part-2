public class MinHeaps {

    private class Node{
        private int key;
        private String value;

        public Node(int key, String value){
            this.value = value;
            this.key = key;
        }
    }

    private Node[] items = new Node[6];
    private int size;

    public void add(String value, int priority){
        items[size++] = new Node(priority, value);
        heapify();
    }

    public void remove(){
        items[size - 1] = null;
        size--;
    }

    public void heapify(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        for(int i = size-1; i >= 0; i--){
            heapify(i);
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void heapify(int index){
        
        var parentIndex = (index - 1) / 2;
        
        if(items[index].key < items[parentIndex].key){
            swap(index, parentIndex);
            heapify(parentIndex);
        }
        
    }

    private void swap(int first, int second){
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private static int leftIndex(int index){
        return (index * 2) + 1;
    }    

    private static int rightIndex(int index){
        return (index * 2) + 2;
    } 
    
}
