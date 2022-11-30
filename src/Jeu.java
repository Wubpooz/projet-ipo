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
        j.terrain.print();

        for(int i=0;i<10;i++) {
            j.tour();
            j.terrain.print();
        }

        /*
        while (j.sortis<5){
            j.tour();
        }*/

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

        int ipr = i;
        int jpr = j;
        switch(((EntiteMobile) e).getDir()){
            case nord : ipr--;break;
            case sud : ipr++;break;
            case est : jpr++;break;
            case ouest : jpr--;break;
        }

        ((EntiteMobile) e).action((CaseTraversable) cases[i][j], (CaseTraversable) cases[ipr][jpr]);

        //this.terrain.print();
    }


    public boolean partieFinie() {  // A FAIRE
        if(sortis>=3){
            return true;
        }
        return false;
    }
}
