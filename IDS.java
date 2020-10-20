public class IDS extends Algoritm
{

    public IDS(boolean isGraph)
    {
        super(isGraph);
    }

    @Override
    public void execute()
    {

        for (int adancime = 0; adancime < Integer.MAX_VALUE; adancime++)
        {
            DLS cautareDLS = new DLS(isGraph, adancime);
            cautareDLS.setProblem(problem);

            int resultat = cautareDLS.cautare(problem.getStareInitiala(), adancime);

            drum = cautareDLS.drum;
            raspuns = cautareDLS.raspuns;
            nodVizitat = cautareDLS.nodVizitat;
            nodExpandat = cautareDLS.nodExpandat;
            maxNodInMemorie = cautareDLS.maxNodInMemorie;

            //null -> a gasit solutia
            // -1 -> eroare in cautare
            if (cautareDLS.raspuns != null|| resultat == -1)
                break;

        }

    }
}
