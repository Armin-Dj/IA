
import java.util.ArrayList;
import java.util.List;

public class NavProblem extends Problem 
{
    private int[][] map;
    private int[] drumDrept;

    public NavProblem() 
    {
        initProblem();
    }


    public boolean testStareFinala(Stare stare) 
    {
        return stareFinala.equals(stare);
    }

    @Override
    public ArrayList<Integer> actiuni(Stare stare) 
    {
        ArrayList<Integer> actiune = new ArrayList<>();
        for (int i = 0; i < map[((StareNav) stare).getID()].length; i++) 
        {
            if (map[((StareNav) stare).getID()][i] != 0) 
            {
                if (null != stare.parinte)
                {
                    if (i != ((StareNav) stare.parinte).getID())
                        actiune.add(i);
                } 
                else
                    actiune.add(i);
            }
        }
        return actiune;
    }

    @Override
    public Stare urmatoareaStare(Stare stare, int actiune) 
    {
        if (actiuni(stare).contains(actiune)) 
        {
            StareNav urmStare = new StareNav(actiune);
            urmStare.parinte = stare;
            urmStare.act = actiune;
            urmStare.costCale = stare.costCale + costPas(stare, actiune, urmStare);
            return urmStare;
        } 
        else 
        {
            System.out.println("wrong action");
            return null;
        }
    }

    @Override
    public int costPas(Stare primaStare, int actiune, Stare adouaStare) 
    {
        return costPas(primaStare, adouaStare);
    }

    public int costPas(Stare primaStare, Stare adouaStare) 
    {
        if (primaStare instanceof StareNav && adouaStare instanceof StareNav) 
        {
            if (map[((StareNav) primaStare).getID()][((StareNav) adouaStare).getID()] != 0)
                return map[((StareNav) primaStare).getID()][((StareNav) adouaStare).getID()];
            else 
            {
                System.out.println("invalid step cost");
                return -1;
            }
        } 
        else 
        {
            System.out.println("invalid step cost");
            return -1;
        }
    }

    public int costPas(int primaStare, int adouaStare) 
    {
        return costPas(new StareNav(primaStare), new StareNav(adouaStare));
    }

    @Override
    public int costCale(List<Integer> cale) 
    {
        int cost = 0;
        for (int i = 0; i < cale.size() - 2; i++) 
        {
            cost += costPas(cale.get(i), cale.get(i + 1));
            if (i == cale.size() - 3) 
            {
                cost += costPas(cale.get(i + 1), 0);
            }
        }
        return cost;
    }

    @Override
    public int heuristic(Stare stare) 
    {
        return drumDrept[((StareNav) stare).getID()];
    }

    private void initProblem() 
    {
        stareInitiala = new StareNav(0);
        stareFinala = new StareNav(12);

        //harta asta o am de pe internet, este harta oraselor din romania
        map = new int[][]{
                {0, 75, 0, 140, 118, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {75, 0, 71, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 71, 0, 151, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {140, 0, 151, 0, 0, 0, 0, 0, 0, 80, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0},
                {118, 0, 0, 0, 0, 111, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 111, 0, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 70, 0, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 75, 0, 120, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 120, 0, 146, 138, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 80, 0, 0, 0, 0, 146, 0, 97, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 138, 97, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 211, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101, 211, 0, 90, 85, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 85, 0, 0, 98, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 98, 0, 86, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 142, 0, 0, 0, 92, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 92, 0, 87},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 87, 0}
        };

        //acesta este costul fiecarui drum
        drumDrept = new int[]{366, 374, 380, 253, 329, 244, 241, 242,
                160, 193, 98, 178, 0, 77, 80, 151, 161, 199, 226, 234};
    }


}
