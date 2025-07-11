package DSA;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS
{
    int v;
    int e;
    int adj[][];

    DFS(int v, int e)
    {
        this.v = v;
        this.e = e;
        adj = new int[v][e];

        for(int row=0; row<v;row++)
        {
            adj[row]=new int[v];
            for(int col=0; col<v; col++)
            {
                adj[row][col]=0;
            }
        }
    }
    public void newEdge(int start, int e)
    {
        adj[start][e]=1;
        adj[e][start]=1;
    }
    public void DepthFS(int start, boolean visited[])
    {
        System.out.println(start+" ");
        visited[start]=true;
        for(int i=0; i<v; i++)
        {
            if(adj[start][i]==1 && (!visited[i]))
            {
                DepthFS(i, visited);
            }
        }
    }

    public static void main(String[] args)
    {
        int v=8, e=8;
        DFS O = new DFS(v,e);
        O.newEdge(0,1);
        O.newEdge(0,2);
        O.newEdge(1,3);
        O.newEdge(2,4);
        O.newEdge(2,6);
        O.newEdge(6,7);
        O.newEdge(3,5);
        O.newEdge(5,7);
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        O.DepthFS(0, visited);
    }
}
