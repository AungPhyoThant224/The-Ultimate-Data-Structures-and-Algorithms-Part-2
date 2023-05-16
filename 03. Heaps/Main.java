import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        // Heaps heaps = new Heaps();
        // heaps.insert(10);
        // heaps.insert(5);
        // heaps.insert(17);
        // heaps.insert(4);
        // heaps.insert(22);
        // heaps.remove();

        // -----------Heaps Sort----------
        // int[] numbers = {5,3,2,10,1,4};
        // Heaps heaps = new Heaps();
        // for(var number : numbers){
        //     heaps.insert(number);
        // }
        // for(int i = 0; i < numbers.length; i++){
        //     numbers[i] = heaps.remove();
        // }
        // System.out.println(Arrays.toString(numbers));

        // ---------------Heapify---------------
        // int[] numbers = {5, 3, 8, 4, 1, 2};
        // int[] numbers = {5, 6, 7, 9, 11, 13};
        // MaxHeaps.heapify(numbers);
        // System.out.println(Arrays.toString(numbers));

        // --------------Largest Item at K-------------
        // int[] numbers = {5, 3, 8, 4, 1, 2};
        // System.out.println(MaxHeaps.getKthLargest(numbers, 3));

        // ------------Exercises-----------------------
        // int[] numbers = {1, 4, 5, 3, 1, 2};
        // System.out.println(MaxHeaps.isMaxHeap(numbers));

        MinHeaps heaps = new MinHeaps();
        heaps.add("5", 5);
        heaps.add("3", 3);
        heaps.add("8", 8);
        heaps.add("4", 4);
        heaps.add("1", 1);
        heaps.add("2", 2);
        heaps.remove();
        heaps.add("8", 8);
    }
}