public class Main{
    public static void main(String[] args) {
        // Tries tries = new Tries();
        // tries.insert("can");
        // tries.insert("cat");

        TriesWithHash tries = new TriesWithHash();
        tries.insert("care");
        tries.insert("car");
        tries.remove("care");
        System.out.println(tries.contains("care"));
        System.out.println(tries.contains("car"));
    }
}