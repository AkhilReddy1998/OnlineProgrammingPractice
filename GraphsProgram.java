public class GraphsProgram {
    public static void main(String[] args) {
        Graphs graph = new Graphs();
        graph.addNode("D");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        //graph.addEdge("A", "B");
        //graph.addEdge("B", "C");
        graph.addEdge("A", "C");
        //graph.addEdge("D", "A");
        //graph.print();
        //graph.traverseDFS("A");
        //graph.traverseBFS("A");
        //graph.topologicalSort();
        System.out.println(graph.hasCycle());
    }
}