public abstract class Case {
    protected final int lig;
    protected final int col;

    Case(int l, int c){lig=l;col=c;}

    abstract boolean estLibre();



}
