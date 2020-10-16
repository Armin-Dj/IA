import java.util.Comparator;
public class Asteluta extends Algoritm 
{
    public Asteluta(boolean isGraph) 
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
                Stare copil = problem.urmatoareaStare(s, actiune);
                nodVizitat++;
                if (isGraph) 
                {
                    if (!exploratLista.contains(copil) && !totalLista.contains(copil)) 
                    {
                        totalLista.add(copil);
                    } else if (totalLista.contains(copil)) 
                    {
                        //if copil is in frontier with higher PATH-COST then replace that frontier node with copil
                        Stare temp = totalLista.get(totalLista.indexOf(copil));
                        if (temp.costCale > copil.costCale) 
                        {
                            temp.parinte = copil.parinte;
                            temp.costCale = copil.costCale;
                        }
                    }
                } 
                else 
                {
                    totalLista.add(copil);
                }
            }

            totalLista.sort(new Comparator<Stare>() 
            {
                @Override
                public int compare(Stare s1, Stare s2) 
                {
                    return ((Integer) (s1.costCale + problem.heuristic(s1))).
                            compareTo(s2.costCale + problem.heuristic(s2));
                }
            });

            maxNodInMemorie = Integer.max(maxNodInMemorie, totalLista.size() + exploratLista.size());

        }
    }
}
