public class CaseLibre extends CaseTraversable{

    CaseLibre(int l, int c){super(l,c);}
    CaseLibre(int l, int c, Entite e){super(l,c, e);}


    public String toString() {
        if (contenu==null){
            return "   ";
        }
        else{
            return super.toString();
        }
    }
}
