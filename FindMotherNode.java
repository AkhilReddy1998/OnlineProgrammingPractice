//https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
public class FindMotherNode {
    public static void main(String[] args) {
        Graphs graph = new Graphs();
        graph.addNode("0");
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addEdge("0", "3");
        graph.addEdge("0", "2");
        graph.addEdge("1", "0");
        graph.addEdge("2", "1");
        graph.addEdge("3", "4");
        graph.print();
        graph.findMothernode();
    }
}