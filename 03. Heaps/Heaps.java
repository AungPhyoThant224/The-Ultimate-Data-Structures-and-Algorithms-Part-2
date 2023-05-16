public class Heaps {
    private int[] items = new int[10];
    private int size;

    public void insert(int item){
        if(isFull()){
            throw new IllegalStateException();
        }
        items[size++] = item;
        bubbleUp();
    }

    public int remove(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        var removeVal = items[0];
        items[0] = items[size -1];
        items[size-1] = 0; 
        size--;
        bubbleDown();
        return removeVal;
    }

    public boolean isFull(){
        return size == items.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void bubbleUp(){
        int index = size - 1;
        while(index > 0 && items[index] >  items[parent(index)]){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // ---------------Mosh Solution--------------
    private void bubbleDown(){
        int index = 0;
        while(index <= size && !isValidParent(index)){
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    //--------------My Solution---------------
    // private void bubbleDown(){
    //     int index = 0;
    //     while(index < size){
    //         if(items[index] < items[leftChildIndex(index)] || items[index] < items[rightChild(index)]){
    //             if(items[leftChildIndex(index)] > items[rightChildIndex(index)]){
    //                 swap(index, leftChildIndex(index));
    //                 index = leftChildIndex(index);
    //             }
    //             else if(items[rightChildIndex(index)] > items[leftChildIndex(index)]){
    //                 swap(index, rightChildIndex(index));
    //                 index = rightChildIndex(index);
    //             }
    //         }
    //         else{
    //             break;
    //         }
    //     }
    // }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= size;
    }

    private int largerChildIndex(int index){
        if(!hasLeftChild(index)){
            return index;
        }

        if(!hasRightChild(index)){
            return leftChildIndex(index);
        }

        return leftChild(index) > rightChild(index) ?
            leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index){
        if(!hasLeftChild(index)){
            return true;
        }

        var isValid = items[index] >= leftChild(index);

        if(hasRightChild(index)){
            isValid = isValid & items[index] >= rightChild(index);
        }

        return isValid;
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index){
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index){
        return (index * 2) + 2;
    }

    private int parent(int index){
        return (index -1) / 2;
    }

    private void swap(int first, int second){
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
}
