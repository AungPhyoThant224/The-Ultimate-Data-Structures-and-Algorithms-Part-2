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

    public void remove(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        items[0] = items[size -1];
        items[size-1] = 0; 
        size--;
        bubbleDown();
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

    private void bubbleDown(){
        int index = 0;
        while(index < size){
            if(items[index] < items[leftChild(index)] || items[index] < items[rightChild(index)]){
                if(items[leftChild(index)] > items[rightChild(index)]){
                    swap(index, leftChild(index));
                    index = leftChild(index);
                }
                else if(items[rightChild(index)] > items[leftChild(index)]){
                    swap(index, rightChild(index));
                    index = rightChild(index);
                }
            }
            else{
                break;
            }
        }
    }

    private int leftChild(int index){
        return (index * 2) + 1;
    }

    private int rightChild(int index){
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
