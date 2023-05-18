public class Main{
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("p");
        graph.addNode("q");
        graph.addNode("c");
        graph.addNode("r");

     
        // graph.addEdges("A", "B");
        // graph.addEdges("B", "D");
        // graph.addEdges("D", "C");
        // graph.addEdges("A", "C");
        // graph.removeNode("A");
        // graph.print();
        // graph.traverseDepthFirstIterative("A");
        // graph.breadthFirst("A");

        // graph.addNode("X");
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("P");
        // graph.addEdges("X" , "A");
        // graph.addEdges("X" , "B");
        // graph.addEdges("A" , "P");
        // graph.addEdges("B" , "P");
        // System.out.println(graph.topologicalSort().toString());
        graph.getNode();
    }
}