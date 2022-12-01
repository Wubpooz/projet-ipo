public class Joueur extends EntiteMobile{

    Joueur(){super(3);}

    @Override
    public String toString(String background) {return background.charAt(0)+"H"+background.charAt(2);}

    public void avance(CaseTraversable courante, Case cible){
        if (!(cible instanceof CaseIntraversable) && cible.estLibre()){
            ((CaseTraversable) cible).entre(courante.getContenu());
            courante.vide();
        }

    }

    public boolean sors(CaseTraversable courante){ //j'ai pensé à la faire return 1 si on est sur la sortie mais c'est chiant pour le faire parvenir à la classe Jeu.  * en fait je vais le faire comme ça en apssant par terrain lol
        if(courante instanceof Sortie){
            courante.vide();
            return true;
        }
        return false;
    }

}
