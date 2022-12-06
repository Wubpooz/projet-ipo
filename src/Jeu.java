import java.util.Random;

public class Jeu {

    Terrain terrain;
    int sortis;

    int dead;

    /* Initialisation d'un jeu avec le terrain initial décrit dans
       le fichier [f] donné en paramètre */
    public Jeu(String f) {
        this.terrain = new Terrain(f);
        this.sortis = 0;
        this.dead=0;
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
        }while(!(e instanceof EntiteMobile) || !((EntiteMobile) e).peutJouer());

        int ipr = i;
        int jpr = j;
        switch(((EntiteMobile) e).getDir()){
            case nord : ipr--;break;
            case sud : ipr++;break;
            case est : jpr++;break;
            case ouest : jpr--;break;
        }


        if(((CaseTraversable) cases[i][j]).getContenu() instanceof Personnage && ((CaseTraversable) cases[ipr][jpr]) instanceof Sortie){sortis++;}

        ((EntiteMobile) e).action((CaseTraversable) cases[i][j], (CaseTraversable) cases[ipr][jpr]);


        if(((CaseTraversable) cases[i][j]).getContenu() instanceof Monstre && ((CaseTraversable) cases[ipr][jpr]).getContenu() instanceof Personnage && ((CaseTraversable) cases[ipr][jpr]).getContenu().getResistance()==0){dead++;}

        for(int k=0;k<terrain.getHauteur();k++){
            for(int m=0;m<terrain.getLargeur();m++){
                if(cases[k][m] instanceof CaseTraversable &&( ((CaseTraversable) cases[k][m]).getContenu() instanceof Joueur)){
                    if(((Joueur) ((CaseTraversable) cases[k][m]).getContenu()).getResistance()==0){terrain.joueur=0;}
                }
            }
        }


        if(terrain.joueur==0){sortis+=1;}
        if(terrain.joueur==-1){sortis/=2;}

        ((CaseTraversable) cases[i][j]).removeIfDead();
        ((CaseTraversable) cases[ipr][jpr]).removeIfDead();

        //this.terrain.print();
    }


    public boolean partieFinie() {return sortis+dead>=3 || terrain.joueur==0 || terrain.joueur==-1;}
}
