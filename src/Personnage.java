public class Personnage extends EntiteMobile{

    Personnage(Direction d){super(d);}
    Personnage(){super();}

    public String toString(String bg){
        switch (d) {
            case nord: return "^";
            case sud: return "v";
            case est: return "<";
            case ouest: return ">";
        }
        return null;
    }
}
