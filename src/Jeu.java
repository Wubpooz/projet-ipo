import java.util.Random;

public class Jeu {

    Terrain terrain;
    int sortis;

    /* Initialisation d'un jeu avec le terrain initial décrit dans
       le fichier [f] donné en paramètre */
    public Jeu(String f) {
        this.terrain = new Terrain(f);
        this.sortis = 0;
    }


    public static void main(String[] args) {
        Jeu j = new Jeu("laby1.txt");
        //j.terrain.print();


    }

    public void tour() {
        Random rnd = new Random();
        Case[][] cases = terrain.getCarte();
        int i = rnd.nextInt(terrain.getHauteur());
        int j = rnd.nextInt(terrain.getLargeur());
        Entite e = ((CaseTraversable) cases[i][j]).getContenu();
        do {
            i = rnd.nextInt(terrain.getHauteur());
            j = rnd.nextInt(terrain.getLargeur());
            e = ((CaseTraversable) cases[i][j]).getContenu();
        }while(!(e instanceof EntiteMobile));

        switch (((EntiteMobile) e).getDir()){
            case nord : i--;
            case sud :
        }

        this.terrain.print();
    }

    public boolean partieFinie() {  // A FAIRE
        return true;
    }
}
