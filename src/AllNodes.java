import java.util.*;
public class AllNodes
{
    static void addEdges(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void BFS(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]=true;
        System.out.print("BFS Traversal: ");
        while(!q.isEmpty())
        {
            int node = q.poll();
            System.out.print(node+" ");
            for(int neighbor : adj.get(node))
            {
                if(!visited[neighbor])
                {
                    visited[neighbor]=true;
                    q.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    static void DFS(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited)
    {
        visited[node]=true;
        System.out.println(node+ " ");
        for(int neighbor : adj.get(node))
        {
            if(!visited[neighbor])
            {
                DFS(adj,neighbor,visited);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of vertices: ");
        int v = sc.nextInt();
        System.out.println("Enter no of Edges: ");
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter Edges (u v): ");
        for(int i=0; i<e; i++)
        {
            int u = sc.nextInt();
            int v2 = sc.nextInt();
            addEdges(adj,u,v2);
        }
        System.out.println("Enter Starting node:");
        int start= sc.nextInt();

        boolean[] visitedBFS = new boolean[v];
        BFS(adj,start,visitedBFS);

        boolean[] visitedDFS = new boolean[v];
        System.out.println("DFS Traversal");
        DFS(adj,start,visitedDFS);

        System.out.println();
        sc.close();

    }
}
