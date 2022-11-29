public class Joueur extends Entite{

    private Direction dir;
    Joueur(){super(3);dir=Direction.random();}

    public void chgDir(Direction d){dir=d;}
    public Direction getDir(){return dir;}
    @Override
    public String toString(String background) {return background.charAt(0)+"H"+background.charAt(2);}
}
