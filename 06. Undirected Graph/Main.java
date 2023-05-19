public class Main{
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 1);
        // graph.print();
        System.out.println(graph.getShortestDistance("A", "C"));
        System.out.println(graph.getShortestPath("A", "C"));
    }
}