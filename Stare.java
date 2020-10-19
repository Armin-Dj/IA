public abstract class Stare
{
    protected Stare parinte;
    protected int act;
    protected int costCale;

    public Stare()
    {
        parinte = null;
        act = -1;
        costCale = 0;
    }

    public int getAct()
    {
        return act;
    }
}