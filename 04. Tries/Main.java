public class Main{
    public static void main(String[] args) {
        // Tries tries = new Tries();
        // tries.insert("can");
        // tries.insert("cat");

        TriesWithHash tries = new TriesWithHash();
        tries.insert("can");
        tries.insert("cat");
        System.out.println(tries.contains("can"));
    }
}