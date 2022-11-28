public class Monstre extends EntiteMobile{

    Monstre(Direction d){super(d);}
    @Override
    public String toString(String bg){
        switch (d) {
            case nord: return bg.charAt(0)+"m"+bg.charAt(2);
            case sud: return bg.charAt(0)+"w"+bg.charAt(2);
            case est: return bg.charAt(0)+"»"+bg.charAt(2);
            case ouest: return bg.charAt(0)+"«"+bg.charAt(2);
        }
        return null;
    }
}
