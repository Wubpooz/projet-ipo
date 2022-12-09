public class Joueur extends Entite{

    Joueur(int res){super(res);}

    @Override
    public String toString(String background) {return background.charAt(0)+"H"+background.charAt(2);}

    public void avance(CaseTraversable courante, Case cible){
        if (!(cible instanceof CaseIntraversable) && cible.estLibre()){
            ((CaseTraversable) cible).entre(courante.getContenu());
            courante.vide();
        }
    }

    //j'ai pensé à la faire return 1 si on est sur la sortie mais c'est chiant pour le faire parvenir à la classe Jeu.  * en fait je vais le faire comme ça en apssant par terrain lol
    public boolean sors(CaseTraversable courante){
        if(courante instanceof Sortie){
            courante.vide();
            return true;
        }
        return false;
    }

    public int damage(Case cible){     // permet de taper les monstres
        if (!(cible instanceof CaseIntraversable) && !cible.estLibre() && ((CaseTraversable) cible).getContenu() instanceof Monstre) {
            ((CaseTraversable) cible).getContenu().decRes(1);
            if(((CaseTraversable) cible).getContenu().getResistance()<=0){return 1;}    // 1 = one less monster, if all are killed you win also
            System.out.println("resistance : "+((CaseTraversable) cible).getContenu().getResistance());
        }
        return 0;
    }


}
