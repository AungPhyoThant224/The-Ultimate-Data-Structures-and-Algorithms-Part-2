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
        int[] numbers = {5,3,2,10,1,4};
        Heaps heaps = new Heaps();
        for(var number : numbers){
            heaps.insert(number);
        }
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = heaps.remove();
        }
        System.out.println(Arrays.toString(numbers));
    }
}