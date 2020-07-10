import java.util.*;

public class Graphs {
    private class Node {
        String label;

        Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    Map<String, Node> nodes = new HashMap<>();
    Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var new_node = new Node(label);
        nodes.putIfAbsent(label, new_node);
        adjacencyList.putIfAbsent(new_node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var from_node = nodes.get(from);
        if (from_node == null)
            throw new IllegalArgumentException();
        var to_node = nodes.get(to);
        if (to_node == null)
            throw new IllegalArgumentException();
        adjacencyList.get(from_node).add(to_node);
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
            else
                System.out.println(source + " has no Connections");
        }
    }

    public void removeEdge(String from, String to) {
        var from_node = nodes.get(from);
        if (from_node == null)
            throw new IllegalArgumentException();
        var to_node = nodes.get(to);
        if (to_node == null)
            throw new IllegalArgumentException();
        // Now see if they are having a Edge
        var check = adjacencyList.get(from_node).contains(to_node);// Check if the Node as any edge
        if (check)// If check is true then there is connection
            adjacencyList.get(from_node).remove(to_node);// Now we deleted the connection
        else // No connection is there
            System.out.println("No connection exists between" + from + " and " + to);
    }

    public void removeNode(String member) {
        // First check if the Node exists;
        if (!nodes.containsKey(member))
            throw new IllegalArgumentException();
        // Now we have confirmation that memeber exists.
        // 1) Delete the Node(member) from the adjacencyList
        var member_address = nodes.get(member);
        adjacencyList.remove(member_address);
        // Now we should loop thorugh adjacencyList to find if any Node as any
        // connection with our memeber
        for (var node : adjacencyList.keySet()) {
            // We have all the Node & List<Connections>
            // Loop through List
            for (var connections : adjacencyList.get(node)) {
                if (connections.label == member) {// We only need this if List<> has member to delete
                    System.out.println(node.label + " is connected to: " + member);
                    adjacencyList.get(node).remove(member_address);
                    // We shouldn't delete element of List while looping through it
                    // Hence we break out of the loop
                    System.out.println("I am deleted");
                    break;
                }
            }
        }

    }

    public void traverseDFS(String node) {
        var node_address = nodes.get(node);
        if (node_address != null)
            traverseDFS(nodes.get(node), new HashSet<String>());
    }

    private void traverseDFS(Node node, HashSet<String> alreadyTravelled) {
        System.out.println(node.label);
        var connectionsOfNode = adjacencyList.get(node);
        alreadyTravelled.add(node.label);// Even if the string exists it doesn't return exception
        for (var connection : connectionsOfNode) {
            // Check if connection is in alreadyTravelled Set
            if (!alreadyTravelled.contains(connection.label))// if no, recurse and the node will be added look at 2nd
                                                             // line of this function
                traverseDFS(connection, alreadyTravelled);// Now start recursing with the Node

        }
    }

    public void traverseBFS(String node) {
        var node_address = nodes.get(node);
        if (node_address == null)
            return;
        HashSet<String> visitedNodes = new HashSet<>();
        visitedNodes.add(node);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node_address);
        while (!queue.isEmpty()) {
            var current_node = queue.remove();
            System.out.println(current_node.label);
            // Get connections of current_node
            for (var connection : adjacencyList.get(current_node)) {
                if (!visitedNodes.contains(connection.label)) {// If not present add
                    visitedNodes.add(connection.label);
                    // Now add it stack
                    queue.add(connection);
                }
            }
        }
    }

    public void topologicalSort() {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> visitedNodes = new HashSet<>();
        for (var node : nodes.values())
            topologicalSort(node, stack, visitedNodes);

        System.out.println(stack);
        System.out.println(visitedNodes);
    }

    private void topologicalSort(Node node, Stack<Node> stack, HashSet<Node> visitedNodes) {

        if (visitedNodes.contains(node))
            return;
        visitedNodes.add(node);
        for (var connection : adjacencyList.get(node))
            topologicalSort(connection, stack, visitedNodes);

        stack.push(node);
    }

    public boolean hasCycle() {
        HashSet<Node> allNodes = new HashSet<>();
        allNodes.addAll(nodes.values());
        HashSet<Node> visiting = new HashSet<>();
        HashSet<Node> visited = new HashSet<>();
        while (!allNodes.isEmpty()) {
            var current = allNodes.iterator().next();
            if (hasCycle(current, allNodes, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node current, HashSet<Node> allNodes, HashSet<Node> visiting, HashSet<Node> visited) {
        allNodes.remove(current);
        visiting.add(current);
        for (var neighbour : adjacencyList.get(current)) {
            if (visited.contains(neighbour))
                continue;
            if (visiting.contains(current))
                return true;
            if (hasCycle(neighbour, allNodes, visiting, visited))
                ;
            return true;
        }
        visiting.remove(current);
        visited.add(current);
        return false;
    }

    public void findMothernode() {
        int numberOfNodesInGraph = nodes.size();
        Set<String> visitedNodes = new HashSet<>();
        for (var source : adjacencyList.keySet()) {
            var getConnections = adjacencyList.get(source);
            if (getConnections.size() > 0) {
                System.out.println("Source is: " + source.label);
                // visitedNodes.add(source.label);
                for (int i = 0; i < getConnections.size(); i++) {
                    var to_node = getConnections.get(i);
                    System.out.println("Child " + (i + 1) + " is: " + to_node.label);
                    visitedNodes = traverseGraph(visitedNodes, to_node);
                    System.out.println(visitedNodes);
                    if (visitedNodes.size() >= numberOfNodesInGraph - 1) {
                        System.out.println("Mother Node is: " + source.label);
                    }
                    visitedNodes.clear();
                }
            }
            visitedNodes.clear();
            System.out.println("************************************************************");
        }
    }

    private Set<String> traverseGraph(Set<String> visitedNodes, Node node) {
        visitedNodes.add(node.label);
        var get_to_node_connections = adjacencyList.get(node);
        for (var to_node : get_to_node_connections) {
            System.out.println("Child is: " + to_node.label);
            if (!visitedNodes.contains(to_node.label))
                traverseGraph(visitedNodes, to_node);
        }
        return visitedNodes;
    }
}
