public class Joueur extends Entite{

    private Direction dir;
    Joueur(){super(3);dir=Direction.random();}

    //public void chgDir(Direction d){dir=d;}
    //public Direction getDir(){return dir;}
    @Override
    public String toString(String background) {return background.charAt(0)+"H"+background.charAt(2);}

    public void avance(String d){
        switch (d){
            case "up":System.out.println("up");break;
            case "down":System.out.println("down");break;
            case "right":System.out.println("right");break;
            case "left":System.out.println("left");break;
            case "sortie":System.out.println("sortie");break;
        }
    }

}
