package sortVisualizer;

import javax.swing.JFrame;
import java.io.*;
import java.util.*;

class BFS
{
    private int                 nrVert;
    private LinkedList<Integer> lista[];

    BFS(int v)
    {
        nrVert  = v; 
        lista   = new LinkedList[v];

        for (int i=0; i<v; ++i)
        {
            lista[i] = new LinkedList();
        }
    }

    void addLine(int v,int w)
    {
        lista[v].add(w);
    }

    void algorithm(int s)
    {
        boolean visited[]       = new boolean[nrVert];
        Queue<Integer> queue    = new LinkedList<Integer>();
        visited[s]              = true;

        queue.add(s);

        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = lista[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                { 
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    public static void main(String args[])
    {
        BFS g = new BFS(4);
        g.addLine(0, 1);
        g.addLine(0, 2);
        g.addLine(1, 1);
        g.addLine(1, 2);
        g.addLine(2, 0);
        g.addLine(2, 1);
        g.addLine(2, 2);
        g.addLine(2, 1);
        g.addLine(2, 2);
        g.addLine(2, 3);
        g.addLine(3, 0);
        g.addLine(3, 2);
        g.addLine(3, 3);
        g.algorithm(3);
    }
}