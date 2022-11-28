public class CaseTraversable extends Case{
    protected Entite contenu;


    CaseTraversable(int l, int c){super(l,c);contenu = new Obstacle(-1);}

    CaseTraversable(int l, int c, Entite e){super(l,c); contenu=e;}


    public Entite getContenu(){ return contenu;}

    public void vide(){contenu = new Obstacle(-1);}

    public void entre(Entite e){
        try{
            if(contenu.resistance==-1){contenu = e;}
        }catch(Exception exp){throw exp;}
    }

    public boolean estLibre(){
        try {
            if (contenu.resistance==-1) {
                return true;
            }
            return false;
        }catch(Exception e){throw e;}
    }

    @Override
    public String toString() {return contenu.toString();}
}
