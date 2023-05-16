public class PriorityQueuesWithHeap {
    Heaps heaps = new Heaps();

    public void enqueue(int item){
        heaps.insert(item);
    }

    public int dequeue(){
        return heaps.remove();
    }

    public boolean isEmpty(){
        return heaps.isEmpty();
    }
}
