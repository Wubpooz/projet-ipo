public abstract class Entite {

    protected int resistance;

    Entite(){resistance=0;}
    Entite(int res){resistance=res;}

    public abstract String toString(String background);
    public String toString(){return this.toString("   ");}

    public void decRes(int n){resistance-=n;}

}
