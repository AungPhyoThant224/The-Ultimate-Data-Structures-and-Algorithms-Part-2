public class Main{
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 5);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "C", 2);
        // graph.print();
        // System.out.println(graph.getShortestDistance("A", "C"));
        // System.out.println(graph.getShortestPath("A", "C"));
        var tree = graph.getMinSpanningTree();
        tree.print();
    }
}