public class Main{
    public static void main(String[] args) {
        // Tries tries = new Tries();
        // tries.insert("can");
        // tries.insert("cat");

        TriesWithHash tries = new TriesWithHash();
        tries.insert("care");
        tries.insert("card");
        tries.insert("car");
        tries.insert("careful");
        tries.insert("egg");
        // System.out.println(tries.findWords("c").toString());
        // tries.remove("agg");
        // System.out.println(tries.contains("care"));
        // System.out.println(tries.contains("car"));

        // --------------Exercises-----------------
        // System.out.println(tries.containsRecursive(null));
        // System.out.println(tries.countWords());
        String[] arr = {"care", "dog", "careful"};
        var commonPrefix = tries.longestCommonPrefix(arr);
        System.out.println(commonPrefix);
    }
}