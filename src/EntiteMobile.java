public abstract class EntiteMobile extends Entite {

    protected Direction d;

    EntiteMobile(Direction dir){d=dir;}

    EntiteMobile(Direction dir, int r){ super(r);d=dir;}

    EntiteMobile(){d=Direction.random();}

    public void changDir(Direction dir){d=dir;}

    public void action(CaseTraversable courante, CaseTraversable cible){
        Entite ec = courante.getContenu();
        if(ec instanceof Personnage){
            if (cible instanceof Sortie){

            } else if (cible.estLibre()) {
                cible.entre(ec);
                courante.vide();
            } else if (cible.getContenu() instanceof Obstacle) {
                cible.contenu.decRes(1);
            }
        } else if (ec instanceof Monstre) {
            if(cible.estLibre()){
                cible.entre(ec);
                courante.vide();
            }else if (cible.getContenu() instanceof Obstacle){
               cible.contenu.decRes(1);
            } else if (cible.getContenu() instanceof Personnage) {
                cible.contenu.decRes(1);
            }
        }
        else{
            ((EntiteMobile) courante.contenu).changDir(Direction.random());
        }

        courante.removeIfDead();
        cible.removeIfDead();
    }
}
