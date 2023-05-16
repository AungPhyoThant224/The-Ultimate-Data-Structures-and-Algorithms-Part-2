import java.util.HashMap;

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

    public boolean isEmpty(){
        return root.children == null;
    }
}
