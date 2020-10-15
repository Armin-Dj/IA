import java.util.Scanner;

public class Core{
    public static void main(String[] args) {
        Problem problem = new NavProblem();
        System.out.println("Algoritmi de cautare:");
        System.out.println("1. BFS \n2. DFS\n3. DFS iterative\n4. DFS limited depth\n5. Uniform Cost\n6. Greedy best first search\n7. A*");
        System.out.println("Alegeti unul dintre algoritmi: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.print("alegeti un mod: graph mode(0) or tree mode(1): ");
        int graphChoice = scanner.nextInt();
        boolean isGraph = true;
        if (graphChoice == 1)
            isGraph = false;

        Algoritm algo = new BFS(isGraph);
        switch( choice )
        {
            case 1:
                algo = new BFS(isGraph);
                break;
            case 2:
                // algo = new SearchDFS();
                break;
            default:
                algo = new BFS(isGraph);
                break;
        }

        algo.setProblem(problem);
        algo.execute();
        arataRezultatAlgoritm(algo);
    }

    public static void arataRezultatAlgoritm(Algoritm algo) {
        System.out.println("Result of the " + algo.getClass().getSimpleName());
        System.out.print("path: 0 ");
        for (int i = algo.getDrum().size() - 2; i >= 0; i--) {
            System.out.print(algo.getDrum().get(i) + " ");
        }
        System.out.println();
        System.out.println("path cost: " + algo.raspuns.costCale);
        System.out.println("Depth of the result: " + (algo.getDrum().size() - 1));
        System.out.println("Number of node that has been seen: " + algo.getNodVizitat());
        System.out.println("Number of node that has been expanded: " + algo.getNodExpandat());
        System.out.println("Maximum number of nodes kept in memory: " + algo.getmaxNodInMemorie());
    }

}