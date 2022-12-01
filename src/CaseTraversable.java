public class CaseTraversable extends Case{
    protected Entite contenu;


    CaseTraversable(int l, int c){super(l,c); contenu = null;}

    CaseTraversable(int l, int c, Entite e){super(l,c); contenu=e;}


    public Entite getContenu(){ return contenu;}

    public void vide(){contenu = null;}

    public void entre(Entite e){contenu=e;}

    public boolean estLibre(){return contenu==null;}

    public void removeIfDead(){if(contenu!=null && contenu.resistance==0){contenu=null;}}
    // no error 'cause stops after the first condition in an && if it isn't verified

    @Override
    public String toString() {return contenu.toString();}
}
