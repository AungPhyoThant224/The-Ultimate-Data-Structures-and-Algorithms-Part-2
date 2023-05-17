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

    public void insert(String word){
        var current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch)){
                current.addChild(ch);;
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
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
        }
    }
}
