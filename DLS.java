public class DLS extends Algoritm{
    private int limit;

    public DLS(boolean isGraph, int limit){
        super(isGraph);
        if ( limit < 0)
            System.out.println("Limita este invalida");
        else
            this.limit = limit;
    }

    @Override
    public void execute(){
        cautare();
    }

    @Override
    public void cautare(){
        cautare(problem.getStareInitiala(), limit);
    }

    public int cautare(Stare nod, int limit){
        if(problem.testStareFinala(nod)){
            raspuns = nod;
            creazaSolutieCale(nod);
            return 1;
        }else if ( 0 == limit ){
            return 0;
        }else {
            nodExpandat++;
            boolean taiere = false;
            for (Integer actiune : problem.actiuni(nod)){
                Stare copil = problem.urmatoareaStare(nod, actiune);
                nodVizitat++;
                if(isGraph){
                    if (!exploratLista.contains(copil)){
                        exploratLista.add(nod);
                        int result = cautare(copil, limit - 1);
                        if ( result == 0){
                            taiere = true;
                        }else if(-1 != result){
                            return result;
                        }
                    }
                } else {
                    int result = cautare(copil, limit -1);
                    if (0 == result)
                        taiere = true;
                    else if (-1 == result)
                        return result;
                }
                maxNodInMemorie = Integer.max(maxNodInMemorie, exploratLista.size());
            }

            if(isGraph)
                totalLista.remove(nod);
            if (taiere)
                return 0;
            else
                return -1;
        }
    }
}