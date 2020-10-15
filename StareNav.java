public class StareNav extends Stare {
    private int id;
    public int getID(){
        return id;
    }

    public StareNav(int id){
        super();
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof StareNav))
            return false;
        StareNav other = (StareNav) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "" + id;
    }
}