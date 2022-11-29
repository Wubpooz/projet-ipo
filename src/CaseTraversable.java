public class CaseTraversable extends Case{
    protected Entite contenu;


    CaseTraversable(int l, int c){super(l,c); contenu = null;}

    CaseTraversable(int l, int c, Entite e){super(l,c); contenu=e;}


    public Entite getContenu(){ return contenu;}

    public void vide(){contenu = null;}

    public void entre(Entite e){contenu=e;}

    public boolean estLibre(){return contenu==null;}

    public void removeIfDead(){if(contenu.resistance==0){contenu=null;}}

    @Override
    public String toString() {return contenu.toString();}
}
