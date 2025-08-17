import java.util.*;

public class AdjacencyMatrix
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Vertices : ");
        int v = sc.nextInt();
        System.out.println("Enter the Number of Edges : ");
        int e = sc.nextInt();
        int[][] matrix = new int[v][v];

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v2 = sc.nextInt();
            matrix[u][v2] = 1;
            matrix[v2][u] = 1; // if undirected
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
