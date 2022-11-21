public abstract class EntiteMobile extends Entite {

    protected Direction d;

    EntiteMobile(Direction dir){dir=d;}

    EntiteMobile(){d=Direction.random();}

    public void action(Case courante, Case cible){
        if(cible.estLibre() && (cible instanceof CaseLibre || cible instanceof CaseTraversable) && (this instanceof Personnage || this instanceof  Monstre)){
            ((CaseTraversable) cible).vide();
            ((CaseTraversable) cible).entre(courante.entite);
        }
    }
}
