import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
 
public class DLS
{
    private Stack<Integer> stack;
    private int numberOfNodes;
    private static final int MAX_DEPTH = 3;
 
    public DLS(int numberOfNodes)
    {
        this.numberOfNodes = numberOfNodes;
        this.stack = new Stack<Integer>();
    }
 
    public void DLS(int adjacencyMatrix[][], int source)
    {
        int visited[] = new int[numberOfNodes + 1];
        int element, destination;
        int depth = 0;
 
        System.out.println(source + " at depth " + depth);
        stack.push(source);
        visited[source] = 1;
        depth = 0;
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            destination = element;
            while (destination <= numberOfNodes)
            {
                if (depth < MAX_DEPTH)
                {
                    if (adjacencyMatrix[element][destination] == 1 && visited[destination] == 0)
                    {
                        stack.push(destination);
                        visited[destination] = 1;
                        depth++;
                        System.out.println(destination + " at depth " + depth);
                        element = destination;
                        destination = 1;
                    }
                }
                else
                {
                    return;
                }
                destination++;
            }
            stack.pop();
            depth--;
        }
    }
 
    public static void main(String... arg)
    {
        int number_of_nodes, source;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(3);
            number_of_nodes = scanner.nextInt();
 
            int adjacency_matrix[][] = new int1[number_of_nodes + 1][number_of_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_of_nodes; i++)
                for (int j = 1; j <= number_of_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt();
 
            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();
 
            System.out.println("The Depth limited Search Traversal of Max Depth 3 is");
            DLS depthLimitedSearch = new DLS(number_of_nodes);
            depthLimitedSearch.DLS(adjacency_matrix, source);
 
        } catch (InputMismatchException inputMismatch)
        { 
            System.out.println("Wrong Input format");
        }
        scanner.close();
    }
}