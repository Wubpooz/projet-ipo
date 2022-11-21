public abstract class Entite {

    protected final int resistance;

    Entite(){resistance=0;}
    Entite(int res){resistance=res;}

    abstract String toString(String background);

}
