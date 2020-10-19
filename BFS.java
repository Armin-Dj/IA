public class BFS extends Algoritm{

    public BFS(boolean isGraph)
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
        while(!totalLista.isEmpty())
        {
            Stare s = totalLista.remove();
            if (isGraph)
                exploratLista.add(s);
            nodExpandat++;

            for(Integer actiune: problem.actiuni(s))
            {
                Stare copil = problem.urmatoareaStare(s, actiune);
                nodVizitat++;
                if(isGraph)
                {
                    if(!exploratLista.contains(copil) && !totalLista.contains(copil)){
                        if(problem.testStareFinala(copil))
                        {
                            raspuns = copil;
                            creazaSolutieCale(copil);
                            return;
                        }
                        totalLista.add(copil);
                    }
                }
                else
                {
                    if(problem.testStareFinala(copil))
                    {
                        raspuns = copil;
                        creazaSolutieCale(copil);
                        return;
                    }
                    totalLista.add(copil);
                }
            }
            maxNodInMemorie = Integer.max(maxNodInMemorie, totalLista.size() + exploratLista.size());
        }
    }
}