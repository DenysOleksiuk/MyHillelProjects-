package Project_20.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Map<String, Set<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.put(vertex, new HashSet<>());
    }

    public void addEdge(String vertex1, String vertex2) {

        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            throw new IllegalArgumentException("Vertex does not exist");
        }

        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeEdge(String vertex1, String vertex2) {
        if (adjacencyList.containsKey(vertex1)) {
            adjacencyList.get(vertex1).remove(vertex2);
        }
        if (adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex2).remove(vertex1);
        }
    }

    public void removeVertex(String vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex does not exist");
        }

        for (String neighbor : adjacencyList.get(vertex)) {
            removeEdge(vertex, neighbor);
        }
        adjacencyList.remove(vertex);
    }

    public boolean hasVertex(String vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge(String vertex1, String vertex2) {
        return adjacencyList.containsKey(vertex1) && adjacencyList.get(vertex1).contains(vertex2);
    }






}
