public class Obstacle extends Entite{

    Obstacle(){super(3);}
    Obstacle(int res){super(res);}


    String toString(String background) {
        if (resistance>=3){ return "@@@";}
        if (resistance==2){ return "@@"+background.charAt(0);}
        if (resistance==1){ return background.charAt(0)+"@"+background.charAt(2);}
        return background;
    }
}
