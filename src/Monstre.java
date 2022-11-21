public class Monstre extends EntiteMobile{

    Monstre(Direction d){super(d);}
    Monstre(){super();}

    public String toString(String bg){
        switch (d) {
            case nord: return "m";
            case sud: return "w";
            case est: return "»";
            case ouest: return "«";
        }
        return null;
    }
}
