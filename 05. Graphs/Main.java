public class Main{
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdges("A", "B");
        graph.addEdges("B", "D");
        graph.addEdges("D", "C");
        graph.addEdges("A", "C");
        // graph.removeNode("A");
        // graph.print();
        graph.traverseDepthFirst("A");
    }
}