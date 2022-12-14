public class Personnage extends EntiteMobile{

    Personnage(Direction d){super(d);}
    Personnage(Direction d,int r){super(d,r);}

    @Override
    public String toString(String bg){
        switch (d) {
            case nord: return bg.charAt(0)+"^"+bg.charAt(2);
            case sud: return bg.charAt(0)+"v"+bg.charAt(2);
            case est: return bg.charAt(0)+">"+bg.charAt(2);
            case ouest: return bg.charAt(0)+"<"+bg.charAt(2);
        }
        return null;
    }

}
