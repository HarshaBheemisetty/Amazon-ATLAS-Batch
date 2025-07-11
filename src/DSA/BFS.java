package DSA;

import java.util.*;

public class BFS {
    int v; // number of vertices
    int e; // number of edges
    int[][] adj; // adjacency matrix

    BFS(int v, int e) {
        this.v = v;
        this.e = e;
        adj = new int[v][v];

        // initialize adjacency matrix with 0s
        for (int row = 0; row < v; row++) {
            Arrays.fill(adj[row], 0);
        }
    }

    // method to add undirected edge
    public void newEdge1(int start, int end) {
        adj[start][end] = 1;
        adj[end][start] = 1;
    }

    // Breadth First Search traversal from a given start node
    public void BreadthFS(int start) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int i = 0; i < v; i++) {
                if (adj[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 8, e = 8;
        BFS graph = new BFS(v, e);
        graph.newEdge1(0, 1);
        graph.newEdge1(0, 2);
        graph.newEdge1(1, 3);
        graph.newEdge1(2, 4);
        graph.newEdge1(2, 6);
        graph.newEdge1(6, 7);
        graph.newEdge1(3, 5);
        graph.newEdge1(5, 7);

        System.out.println("BFS traversal starting from node 0:");
        graph.BreadthFS(0);
    }
}
