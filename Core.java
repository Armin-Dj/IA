import java.util.Scanner;

public class Core 
{

    public static void main(String[] args) 
    {
        Problem problem = new NavProblem();
        Algoritm algo;
        System.out.println("Alegeti un algoritm: ");
        System.out.println("1. BFS \n2. DFS\n3. DFS iterative\n4. DFS limited depth" +
                "\n5. Uniform Cost\n6. Greedy best first search\n7. A*");
        System.out.print("Inserati numarul algoritmului: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.print("Alegeti modul graph mode(0) or tree mode(1): ");
        int graphChoice = scanner.nextInt();
        boolean isGraph = true;
        if (graphChoice == 1)
            isGraph = false;
        switch (choice) 
        {
            case 1:
                algo = new BFS(isGraph);
                break;
            case 2:
                algo = new DFS(isGraph);
                break;
            case 3:
                algo = new IDS(isGraph);
                break;
            case 4:
                System.out.print("Introduceti adancimea >0: ");
                int depth = scanner.nextInt();
                algo = new DLS(isGraph, depth);
                break;
            case 5:
                algo = new UCS(isGraph);
                break;
            default:
                algo = new BFS(isGraph);
                break;
        }
        algo.setProblem(problem);
        algo.execute();
        arataRezultat(algo);
    }

    public static void arataRezultat(Algoritm algo) 
    {
        System.out.println("Rezultatul " + algo.getClass().getSimpleName());
        System.out.print("path: 0 ");
        for (int i = algo.getDrum().size() - 2; i >= 0; i--) 
        {
            System.out.print(algo.getDrum().get(i) + " ");
        }
        System.out.println();
        System.out.println("Costul caii: " + algo.raspuns.costCale);
        System.out.println("Adancimea : " + (algo.getDrum().size() - 1));
        System.out.println("Numar noduri vizitate: " + algo.getNodVizitat());
        System.out.println("Numar noduri expandate: " + algo.getNodExpandat());
        System.out.println("Numar noduri in memorie: " + algo.getmaxNodInMemorie());
    }
}
