import java.util.ArrayList;
import java.util.List;

public abstract class Problem
{
    protected Stare stareInitiala;
    protected Stare stareFinala;

    public Stare getStareInitiala()
    {
        return stareInitiala;
    }

    // testStareFinal determina daca unul dintre Stareurile date este Stareul final/necesar
    abstract public boolean testStareFinala(Stare stare);
    abstract public ArrayList<Integer> actiuni(Stare stare);
    abstract public Stare urmatoareaStare(Stare stare, int action);
    abstract public int costPas(Stare primaStare, int action, Stare adouaStare);
    abstract public int costCale(List<Integer> path);

    //Functie pentru heuristica, trebuie override in A*
    public int heuristic(Stare stare)
    {
        return 0;
    }
}