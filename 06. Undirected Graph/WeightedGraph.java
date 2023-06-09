import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class WeightedGraph {
    private class Node{
        private String label;
        List<Edge> edges = new ArrayList<>();

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return label;
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges(){
            return edges;
        }
    }

    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return from + " -> " + to;
        }
    }

    Map<String, Node> nodes = new HashMap<>();
    
    public void addNode(String lable){
        nodes.putIfAbsent(lable, new Node(lable));
    }

    public void addEdge(String from, String to, int weight){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if(fromNode == null || toNode == null){
            return;
        }
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print(){
        for(var node : nodes.values()){
            var edges = node.getEdges();
            if(!edges.isEmpty()){
                System.out.println(node + " is connected to " + edges);
            }
        }
    }

    private class NodeEntry{
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority){
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestDistance(String from, String to){
        var fromNode = nodes.get(from);

        Map<Node, Integer> distance = new HashMap<>();
        for (var node: nodes.values()){
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.replace(fromNode, 0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
            Comparator.comparingInt(ne -> ne.priority)
        );
        queue.add(new NodeEntry(fromNode, 0));

        while(!queue.isEmpty()){
            var current = queue.remove().node;
            visited.add(current);

            for(var edge: current.getEdges()){
                if(visited.contains(edge)){
                    continue;
                }

                var newDistance = distance.get(current) + edge.weight;
                if(newDistance < distance.get(edge.to)){
                    distance.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return distance.get(nodes.get(to));
    }

    public Path getShortestPath(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if(fromNode == null || toNode == null){
            throw new IllegalArgumentException();
        }

        Map<Node, Integer> distance = new HashMap<>();
        for (var node: nodes.values()){
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.replace(fromNode, 0);

        Map<Node, Node> previousNode = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
            Comparator.comparingInt(ne -> ne.priority)
        );
        queue.add(new NodeEntry(fromNode, 0));

        while(!queue.isEmpty()){
            var current = queue.remove().node;
            visited.add(current);

            for(var edge: current.getEdges()){
                if(visited.contains(edge)){
                    continue;
                }

                var newDistance = distance.get(current) + edge.weight;
                if(newDistance < distance.get(edge.to)){
                    distance.replace(edge.to, newDistance);
                    previousNode.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return buildPath(previousNode, toNode);
    }

    public Path buildPath(Map<Node, Node> previousNodes, Node toNode){
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = previousNodes.get(toNode);
        while(previous != null){
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while(!stack.isEmpty()){
            path.add(stack.pop().label);
        }

        return path;
    }

    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();

        for(var node: nodes.values()){
            if(visited.contains(node) && hasCycle(node, null, visited)){
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited){
        
        visited.add(node);
        for(var edge: node.getEdges()){
            if(edge.to == parent){
                continue;
            }

            if(visited.contains(edge.to) || hasCycle(edge.to, parent, visited)){
                return true;
            }
        }
        
        return false;
    }

    public WeightedGraph getMinSpanningTree(){
        var tree = new WeightedGraph();
        if(nodes.isEmpty()){
            return tree;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>(
            Comparator.comparingInt(e -> e.weight)
        );

        if(edges.isEmpty()){
            return tree;
        }

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        while(tree.nodes.size() < nodes.size()){
            var minEdge = edges.remove();
            var nextNode = minEdge.to;

            if(tree.containsNode(nextNode.label)){
                continue;
            }

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

            for(var edge: nextNode.getEdges()){
                if(!tree.containsNode(edge.to.label)){
                    edges.add(edge);
                }
            }
        }
        return tree;
    }

    public boolean containsNode(String label){
        return nodes.containsKey(label);
    }
}
