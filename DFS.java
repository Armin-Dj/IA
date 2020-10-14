import java.io.*;
import java.util.*;

class DFS
{
    private int                 nrVert;
    private LinkedList<Integer> lista[];

    DFS(int v)
    {
        nrVert  = v;
        lista   = new LinkedList[v];

        for (int i=0; i<v; ++i)
        {
            lista[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w)
    {
        lista[v].add(w);
    }

    void utility(int v,boolean visited[])
    {
        visited[v]          = true;
        Iterator<Integer> i = lista[v].listIterator();

        System.out.print(v+" ");

        while (i.hasNext())
        {
            int n = i.next();

            if (!visited[n])
            {
                utility(n, visited);
            }
        }
    }

    void DFS(int v)
    {
        boolean visited[]   = new boolean[nrVert];
        utility(v, visited);
    }

    public static void main(String args[])
    {
        Graph g     = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(3, 3);
        g.addEdge(1, 1);
        g.addEdge(2, 0);
        g.addEdge(3, 1);
        
        g.DFS(2);
    }
}