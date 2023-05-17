public class Main{
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdges("A", "B");
        graph.addEdges("A", "C");
        graph.removeEdges("A", "B");
        // graph.removeNode("A");
        graph.print();
    }
}