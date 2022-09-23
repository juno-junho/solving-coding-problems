import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class Graph4 {

    private int numberOfNodes;
    private HashMap<Integer, List<Integer>> adjacentList;

    public Graph4() {
        this.numberOfNodes = 0;
        this.adjacentList = new HashMap<>();
    }
    void addNode(int node){
        numberOfNodes++;
        adjacentList.put(node, new ArrayList<>());

    }

    void addEdge(int node1, int node2) {
        // undirected
        adjacentList.get(node1).add(node2);
        adjacentList.get(node2).add(node1);
    }
    void showConnections(){
        adjacentList.forEach((node,nodeconnections) -> {
            StringBuilder connections = new StringBuilder();
            nodeconnections.forEach(edge -> connections.append(edge).append(" "));
            System.out.println(node + " --> " + connections);
        });
    }

    public static void main(String[] args) {
        Graph4 graph = new Graph4();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);
        graph.showConnections();
    }
}
