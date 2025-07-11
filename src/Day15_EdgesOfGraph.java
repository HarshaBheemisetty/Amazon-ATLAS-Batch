public class Day15_EdgesOfGraph {

    // Inner class to represent an edge
    static class Edge {
        int src;
        int dest;

        // Constructor
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void main(String[] args) {
        // Number of vertices
        int vertices = 5;

        // Create an array of edges directly (8 edges)
        Edge[] edges = {
                new Edge(1, 2),
                new Edge(1, 3),
                new Edge(1, 4),
                new Edge(2, 4),
                new Edge(2, 5),
                new Edge(3, 4),
                new Edge(3, 5),
                new Edge(4, 5)
        };

        // Display all edges
        System.out.println("Graph edges:");
        for (Edge edge : edges) {
            System.out.println(edge.src + " - " + edge.dest);
        }
    }
}
