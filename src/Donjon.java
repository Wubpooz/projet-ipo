import javax.swing.Timer;

public class Donjon {
    public static void main(String[] args) {
        int tempo = 100;
        Jeu jeu = new Jeu("laby2.txt");
        FenetreJeu graphic = new FenetreJeu(jeu.terrain);
        Timer timer = new Timer(tempo, e -> {
            if (jeu.partieFinie()) {graphic.ecranFinal(jeu.sortis); }
            else{
                jeu.tour();
                graphic.repaint();
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}
