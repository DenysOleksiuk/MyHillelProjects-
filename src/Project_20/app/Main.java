package Project_20.app;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");

        g.addEdge("A", "B");
        g.addEdge("B", "C");

        System.out.println("Is vertex A? " + g.hasVertex("A"));
        System.out.println("Is edge A-C? " + g.hasEdge("A", "C"));
    }
}
