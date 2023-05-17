import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TriesWithHash {
    private class Node{
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value){
            this.value = value;
        }

        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch){
            return children.get(ch);
        }

        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public void remove(char ch){
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');
    private int count;

    public void insert(String word){
        var current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch)){
                current.addChild(ch);;
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
        count++;
    }

    // ---------------Mosh Solution------------
    public boolean contains(String word){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        var current = root;
        for(char ch: word.toCharArray()){
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    // ------------My Solution--------
    // public boolean contains(String word){
    //     var current = root;
    //     if(isEmpty()){
    //         throw new IllegalStateException();
    //     }
    //     char[] charArr = word.toCharArray();
    //     for(int i = 0; i < charArr.length; i++){
    //         if(!current.hasChild(charArr[i])){
    //             return false;
    //         }

    //         current = current.getChild(charArr[i]);

    //         if(i == charArr.length - 1 && current.isEndOfWord == false){
    //             return false;
    //         }

    //     }
    //     return true;
    // }

    public void remove(String word){
        if(word == null){
            throw new IllegalArgumentException();
        }
        remove(root, word, 0);
    }

    public void traverse(){
        traverse(root);
    }

    public boolean isEmpty(){
        return root.children == null;
    }

    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        var theLastNode = theLastNodeOf(prefix);
        findWords(theLastNode, prefix, words);
        return words;
    }

    public boolean containsRecursive(String word){
        if(word == null){
            return false;
        }
        return containsRecursive(root, word, 0);
    }

    public int countWords(){
        return count;
    }

    public String longestCommonPrefix(String[] words){
        if(words == null){
            throw new IllegalStateException();
        }

        if(words.length == 1){
            return words[0];
        }

        String shortestWord = words[0];
        for(int i = 0; i < words.length; i++){
            if(shortestWord.length() > words[i].length()){
                shortestWord = words[i];
            }
        }

        String commonPrefix = "";
        char[] shortestWordArr = shortestWord.toCharArray();
        for(int i = 0; i < shortestWordArr.length; i++){
            for(int j= 0; j < words.length; j++){
                char[] wordArr = words[j].toCharArray();
                if(shortestWordArr[i] != wordArr[i]){
                    return commonPrefix;
                }
            }
            commonPrefix += shortestWordArr[i];
        }

        return commonPrefix;

    }

    private boolean containsRecursive(Node root, String word, int index){
        if(index == word.length()){
            return root.isEndOfWord;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if(child == null){
            return false;
        }
        var result = containsRecursive(child, word, index+1);
        return result == false ? false : true;
    }

    private void findWords(Node root, String prefix, List<String> words){
        if(root == null){
            return;
        }

        if(root.isEndOfWord){
            words.add(prefix);
        }

        for(var child: root.getChildren()){
            findWords(child, prefix + child.value, words);
        }
    }

    private Node theLastNodeOf(String prefix){
        if(prefix == null){
            return null;
        }
        var current = root;
        for(var ch: prefix.toCharArray()){
            var child = current.getChild(ch);
            if(child == null){
                return null;
            }
            current = child;
        }
        return current;
    }

    private void traverse(Node root){
        
        for(var child: root.getChildren()){
            traverse(child);
        }
        System.out.println(root.value);
    }

    private void remove(Node root, String word, int index){
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if(child == null){
            return;
        }

        remove(child, word, index+1);
        if(!child.hasChildren() && !child.isEndOfWord){
            child.remove(ch);
            count--;
        }
    }
}
