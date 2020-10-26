//https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
public class FindMotherNode {
    public static void main(String[] args) {
        Graphs graph = new Graphs();
        graph.addNode("0");
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addNode("5");
        graph.addNode("6");
        graph.addEdge("0", "1");
        graph.addEdge("0", "2");
        graph.addEdge("1", "3");
        graph.addEdge("4", "1");
        graph.addEdge("5", "2");
        graph.addEdge("5", "6");
        graph.addEdge("6", "0");
        graph.addEdge("6", "4");
        graph.print();
        // graph.findMothernode();
        graph.findMothernodeMethod2();
    }
}