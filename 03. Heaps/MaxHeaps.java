public class MaxHeaps {
    public static void heapify(int[] arr){
        var lastParentIndex = arr.length / 2 - 1;
        for(int i = lastParentIndex; i >= 0; i--){
            heapify(arr, i);
        }
    }

    public static int getKthLargest(int[] arr, int K){
        Heaps heaps = new Heaps();

        if(K >= arr.length){
            return -1;
        }

        for(var number : arr){
            heaps.insert(number);
        }

        for(int i = 0; i < K - 1; i++){
            heaps.remove();
        }

        return heaps.max();
        
    }

    private static void heapify(int[] arr, int index){
        var largerIndex = index;

        var leftChild = index * 2 + 1;
        if(leftChild < arr.length && arr[largerIndex] < arr[leftChild] ){
            largerIndex = leftChild;
        }

        var rightChild = index * 2 + 2;
        if(rightChild < arr.length && arr[largerIndex] <  arr[rightChild]){
            largerIndex = rightChild;
        }

        if(largerIndex == index){
            return;
        }

        swap(arr, index, largerIndex);
        heapify(arr, largerIndex);

    }

    private static void swap(int[] arr, int first, int second){
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
