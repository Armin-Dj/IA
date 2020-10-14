import java.io.*;
import java.util.*;
import javafx.util.Pair; 

public class UCS {
    private     Vector<Vector<Integer>>                 graph;
    private     Map<Pair<Integer,Integer>, Integer>     cost;

    UCS(Vector<Integer> goal, int start)
    {
    }
    Vector<Integer> UCS(Vector<Integer> goal, int start)
    {
        Vector<Integer> retVal                      = new Vector<Integer> ();
        PriorityQueue<Map<Integer, Integer> > queue = new PriorityQueue<Map<Integer,Integer> > ();

        Pair<Integer, Integer> p = queue.peek();

        for (int i = 0; i < goal.size(); i++) 
        {
            retVal.add(255);    
        }

        queue.add(new Pair<Integer, Integer> (0,start));
        Map<Integer,Integer> visited;
        int counter = 0;

        while(queue.size( ) > 0)
        {
            int index;
            p = queue.poll();
            p.first *= -1;

            if(find(goal.firstElement(), goal.lastElement(), p.second) != goal.lastElement())
            {
                index = find (goal.firstElement(), goal.lastElement(), p.second) - goal.firstElement();
            }

            if (retVal.get(index) == 255)
            {
                counter ++;
            }

            if(retVal.get(index) > p.first)
            {
                retVal.set(index, p.first);
            }

            queue.poll();

            if(counter == goal.size())
            {
                return retVal;
            }
        }

        if(visited.get(p.second) == 0)
        {
            for (int i = 0; i < graph.get(p.second).size(); i++) 
            {
                queue.add(new Pair<Integer, Integer>(p.first +
                 cost.get(new Pair<Integer, Integer>, Integer> (p.second, graph.get(p.second, i)) * (-1)),
                 graph.get(p.second,i)));
            }

            visited.put(p.second) = 1;
        }

        return retVal;
    }

    public static void main(String[] args) {
        Vector<Vector<Integer>> graph = new Vector<Vector<Integer>>(7);

        graph.add (1, new Vector<Integer>(0));
        graph.add (2, new Vector<Integer>(1));
        graph.add (5, new Vector<Integer>(3));
        graph.add (4, new Vector<Integer>(4));
        graph.add (3, new Vector<Integer>(5));
        graph.add (5, new Vector<Integer>(2));

        cost.add(new Pair<Integer,Integer>(0,1), 3);
        cost.add(new Pair<Integer,Integer>(1,2), 73);
        cost.add(new Pair<Integer,Integer>(3,5), 6);
        cost.add(new Pair<Integer,Integer>(4,4), 4);
        cost.add(new Pair<Integer,Integer>(5,3), 55);
        cost.add(new Pair<Integer,Integer>(2,5), 10);
        
        Vector<Integer> goal = new Vector<Integer>();

        goal.add(6);

        Vector<Integer> answer = UCS(goal,0);

        System.out.println("Min cost from 0 to 6 is %d" answer.toString());

    }
}