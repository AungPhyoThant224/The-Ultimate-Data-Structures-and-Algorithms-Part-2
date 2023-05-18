public class Main{
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdges("A", "B");
        graph.addEdges("B", "C");
        graph.addEdges("C", "D");
        graph.addEdges("D", "A");
        // graph.removeNode("A");
        // graph.print();
        // graph.traverseDepthFirstIterative("A");
        // graph.breadthFirst("A");
        System.out.println(graph.hasCircle());

        // graph.addNode("X");
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("P");
        // graph.addEdges("X" , "A");
        // graph.addEdges("X" , "B");
        // graph.addEdges("A" , "P");
        // graph.addEdges("B" , "P");
        // System.out.println(graph.topologicalSort().toString());
    }
}