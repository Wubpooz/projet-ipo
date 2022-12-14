public abstract class EntiteMobile extends Entite {

    protected Direction d;

    private boolean joué=false;

    EntiteMobile(Direction dir){d=dir;}

    EntiteMobile(Direction dir, int r){super(r);d=dir;}

    EntiteMobile(){d=Direction.random();}

    public void changDir(Direction dir){d=dir;}

    public Direction getDir(){return d;}


    public boolean peutJouer(){
        joué=!(joué);
        return !(joué);
    }

    public void action(CaseTraversable courante, CaseTraversable cible){
        Entite ec = courante.getContenu();
        if(ec instanceof Personnage){
            if (cible instanceof Sortie){
                courante.vide();
            } else if (!(cible instanceof CaseIntraversable) && cible.estLibre()) {
                cible.entre(ec);
                courante.vide();
            } else if (cible.getContenu() instanceof Obstacle) {
                cible.getContenu().decRes(1);
            }
        } else if (ec instanceof Monstre) {
            if(!(cible instanceof CaseIntraversable) && cible.estLibre()){
                cible.entre(ec);
                courante.vide();
            }else if (cible.getContenu() instanceof Obstacle){
               cible.getContenu().decRes(1);
            } else if (cible.getContenu() instanceof Personnage) {
                cible.getContenu().decRes(1);
            } else if (cible.getContenu() instanceof Joueur) {
                cible.getContenu().decRes(1);
            }
        }
        if ((ec instanceof Monstre || ec instanceof Personnage) && (cible instanceof CaseIntraversable)){
            ((EntiteMobile) courante.getContenu()).changDir(Direction.random());
        }
        if (courante.getContenu()!=null && cible.getContenu()!=null && (ec instanceof Personnage && cible.getContenu() instanceof Monstre || cible.getContenu() instanceof Joueur)){
            ((EntiteMobile) courante.getContenu()).changDir(Direction.random());
        }
        if(courante.getContenu()!=null && cible.getContenu()!=null && ec instanceof Monstre && cible.getContenu() instanceof Monstre){
            ((EntiteMobile) courante.getContenu()).changDir(Direction.random());
        }

    }
}
