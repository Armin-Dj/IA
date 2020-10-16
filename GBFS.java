import java.util.Comparator;

public class GBFS extends Algoritm
{
    public GBFS(boolean isGraph) 
    {
        super(isGraph);
    }

    @Override
    public void execute() 
    {
        cautare();
    }

    @Override
    public void cautare() 
    {
        totalLista.add(problem.getStareInitiala());
        nodVizitat++;
        while (!totalLista.isEmpty()) 
        {
            showLists();
            Stare s = totalLista.remove();
            if (problem.testStareFinala(s)) 
            {
                raspuns = s;
                creazaSolutieCale(s);
                return;
            }

            if (isGraph)
                exploratLista.add(s);
            nodExpandat++;

            for (Integer actiune : problem.actiuni(s)) 
            {
                Stare child = problem.urmatoareaStare(s, actiune);
                nodVizitat++;
                if (isGraph) 
                {
                    if (!exploratLista.contains(child) && !totalLista.contains(child)) 
                    {
                        totalLista.add(child);
                    }
                } 
                else 
                {
                    totalLista.add(child);
                }
            }

            //nu e al nostru
            totalLista.sort(new Comparator<Stare>() 
            {
                @Override
                public int compare(Stare s1, Stare s2)
                {
                    return ((Integer) (problem.heuristic(s1))).compareTo(problem.heuristic(s2));
                }
            });

            maxNodInMemorie = Integer.max(maxNodInMemorie, totalLista.size() + exploratLista.size());

        }
    }
}
