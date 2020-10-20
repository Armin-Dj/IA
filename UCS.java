import java.util.Comparator;

public class UCS extends Algoritm {

    public UCS(boolean isGraph)
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
                    }
                    else if (totalLista.contains(copil))
                    {
                        //daca copil este in totalLista cu un cost mai mare atunci schimba acel nod cu copil
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
                public int compare(Stare o1, Stare o2)
                {
                    return ((Integer) o1.costCale).compareTo(o2.costCale);
                }
            });

            maxNodInMemorie = Integer.max(maxNodInMemorie, totalLista.size() + exploratLista.size());

        }
    }


}
