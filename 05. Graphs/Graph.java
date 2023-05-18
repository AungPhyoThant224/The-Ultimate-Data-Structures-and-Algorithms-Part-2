import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.management.Query;

public class Graph {
    private class Node{
        private String label;

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return label;
        }
    }
    

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdges(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if(fromNode == null || toNode == null){
            throw new IllegalArgumentException();
        }

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print(){
        for(var source: adjacencyList.keySet()){
            var target = adjacencyList.get(source);
            if(!target.isEmpty()){
                System.out.println(source + " is connected to " + target);
            }
        }
    }

    public void removeNode(String label){
        var node = nodes.get(label);
        if(node == null){
            return;
        }

        for(var n : adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdges(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if(fromNode == null && toNode == null){
            return;
        }

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirst(String label){
        var node = nodes.get(label);
        if(node == null){
            return;
        }

        traverseDepthFirst(node, new HashSet<>());
    }

    public void traverseDepthFirstIterative(String label){
        var node = nodes.get(label);
        if(node == null){
            return;
        }

        Set<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            var current = stack.pop();

            if(visited.contains(current)){
                continue;
            }

            System.out.println(current);
            visited.add(current);

            for(var neighbour : adjacencyList.get(current)){
                if(!visited.contains(neighbour)){
                    stack.push(neighbour);
                }
            }
        }
        
    }

    public void breadthFirst(String label){
        var node = nodes.get(label);
        if(node == null){
            return;
        }

        Set<Node> visited = new HashSet<>();
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            var current = queue.remove();

            if(visited.contains(current)){
                continue;
            }
            System.out.println(current);
            visited.add(current);

            for(var neighbour : adjacencyList.get(current)){
                if(!visited.contains(neighbour)){
                    queue.add(neighbour);
                }
            }
        }
    }

    public List<String> topologicalSort(){
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for(var node : nodes.values()){
            topologicalSort(node, stack, visited);
        }

        List<String> topoList = new ArrayList<>();
        while(!stack.isEmpty()){
            topoList.add(stack.pop().label);
        }

        return topoList;
    }

    public boolean hasCircle(){
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while(!all.isEmpty()){
            var current = all.toArray(new Node[0])[0];
            if(hasCircle(current, all, visiting, visited)){
                return true;
            }
        }

        return false;
    }

    public void getNode(){
        System.out.println(nodes.values());
    }

    private boolean hasCircle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited){
        all.remove(node);
        visiting.add(node);

        for(var neighbour : adjacencyList.get(node)){
            if(visited.contains(neighbour)){
                continue;
            }
            if(visiting.contains(neighbour)){
                return true;
            }

            if(hasCircle(neighbour, all, visiting, visited)){
                return true;
            }
        }
        visited.add(node);
        return false;
    }

    private void topologicalSort(Node node, Stack<Node> stack, Set<Node> visited){
        if(visited.contains(node)){
            return;
        }

        visited.add(node);

        for(var neighbour: adjacencyList.get(node)){
            topologicalSort(neighbour, stack, visited);
        }

        stack.push(node);
        System.out.println("visited " + visited);
        System.out.println("stack " + stack);
    }

    private void traverseDepthFirst(Node root, Set<Node> visited){
        System.out.println(root);
        visited.add(root);

        for(var node : adjacencyList.get(root)){
            if(!visited.contains(node)){
                traverseDepthFirst(node, visited);
            }
        }
    }

}
