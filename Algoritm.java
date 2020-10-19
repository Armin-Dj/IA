import java.util.LinkedList;

public abstract class Algoritm{
    protected int nodVizitat;
    protected int nodExpandat;
    protected LinkedList<Integer> drum;
    protected int drumCost;
    protected int maxNodInMemorie;
    protected Stare raspuns;

    protected Problem problem;
    protected boolean isGraph;
    protected LinkedList<Stare> totalLista;
    protected LinkedList<Stare> exploratLista;

    public Algoritm(boolean isGraph)
    {
        this.isGraph = isGraph;
        nodVizitat = 0;
        nodExpandat = 0;
        drum = new LinkedList<>();
        drumCost = 0;
        maxNodInMemorie = 0;
        totalLista = new LinkedList<>();
        exploratLista = new LinkedList<>();
    }


    public int getNodVizitat()
    {
        return nodVizitat;
    }

    public int getNodExpandat()
    {
        return nodExpandat;
    }

    public int getmaxNodInMemorie()
    {
        return maxNodInMemorie;
    }

    public LinkedList<Integer> getDrum()
    {
        return drum;
    }

    public void setProblem(Problem problem)
    {
        this.problem = problem;
    }

    public Problem getProblem()
    {
        return problem;
    }
    abstract public void execute();

    public void cautare()
    {

    }

    protected void creazaSolutieCale (Stare stare)
    {
        Stare temp = stare;
        while (null != temp)
        {
            drum.add(temp.act);
            temp = temp.parinte;
        }
    }

    protected void showLists()
    {
        System.out.print("Total liste: ");
        for (Stare stare: totalLista)
        {
            System.out.print(stare+ ", ");
        }
        System.out.print("\texplored list: ");
        for (Stare stare: exploratLista)
        {
            System.out.print(stare+ ", ");
        }
        System.out.println();
    }

}