/**
   Exemple minimal d'interface graphique en Java : ouvre une fenêtre
   dans laquelle l'utilisateur peut cliquer pour afficher des bulles.
 */

import javax.swing.*; /* JFrame, JPanel, ... : fenêtre, affichage, boutons */
import java.awt.*;    /* Graphics : de quoi dessiner */
import java.awt.event.MouseEvent;    /* Actions de la souris */
import java.awt.event.MouseListener; /* Réactions aux actions de la souris */
import java.util.ArrayList;

/**
   La classe JPanel décrit une unité d'affichage à l'intérieur d'une 
   fenêtre graphique. On la spécialise pour définir une méthode d'affichage
   spécifique.

   L'interface MouseListener décrit les éléments capables de réagir aux
   actions de la souris.
 */
public class Cercles extends JPanel implements MouseListener {

    /* Attribut : stocke l'ensemble des cercles à afficher */
    private ArrayList<Cercle> cercles;

    /* Constructeur, prend en paramètres les dimensions de la fenêtre */
    public Cercles(int l, int h) {
        this.cercles = new ArrayList<>();

        /* Le fond sera gris clair */
        setBackground(Color.LIGHT_GRAY);
        /* On donne à la zone d'affichage les dimensions demandées */
        setPreferredSize(new Dimension(l, h));

        /* Création de la fenêtre dans laquelle sera affiché notre JPanel,
           et établissement du lien entre les deux. */
        JFrame frame = new JFrame("Cercles");
        frame.getContentPane().add(this);
        
        /* Quelques incantations pour que la fenêtre soit visible,
           et que le programme s'arrête à la fermeture de la fenêtre. */
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Enregistrement de notre JPanel, pour recevoir les événements
           décrivant les actions de la souris. */
        frame.addMouseListener(this);
    }

    /* Redéfinition de la méthode d'affichage. 
       Le paramètre g est notre "pinceau", c'est en appelant ses méthodes
       que l'on dessine dans le JPanel. */
    public void paintComponent(Graphics g) {
        /* D'abord, on appelle la méthode paintComponent de la classe mère
           elle-même, puis on pourra ajouter notre affichage plus spécifique */
        super.paintComponent(g);
        /* Définition de la couleur dans laquelle seront dessinés les cercles.
           Ici : coordonénes RVB + opacité. */
        g.setColor(new Color(0, 0, 255, 63));
        for (Cercle c : cercles) {
            /* Pour dessiner un disque de centre (c.x, c.y) et de rayon c.r,
               on demande à remplir l'ovale inscrit dans le rectangle avec
               un coin de coordonnées (c.x-c.r, c.y-c.r), et de longueur et
               largeur 2*c.r */
            g.fillOval(c.x - c.r, c.y - c.r, 2*c.r, 2*c.r);
        }
    }

    /* Action à réaliser lors d'un clic de souris. L'argument e donne le
       détail des informations de ce clic. En particulier, les méthodes
       getX() et getY() donnent les coordonnées du point cliqué. */
    @Override
    public void mouseClicked(MouseEvent e) {
        cercles.add(new Cercle(e.getX(), e.getY(), 40));
        /* Mise à jour de l'affichage */
        this.repaint();
    }

    /* Autres actions possibles de la souris, à définir pour satisfaire
       le "implements MouseListener", mais sans contenu ici puisque l'on
       ne souhaite rien faire dans ces différentes situations. */
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    /* Programme principal : on se contente de créer une instance de
       Cercles (notre extension de JPanel), qui crée elle-même la fenêtre
       JFrame dans laquelle elle s'affichera. */
    public static void main(String[] args) {
        Cercles c = new Cercles(800, 600);
    }
}


class Cercle {
    /* Cercle, décrit par coordonnées et rayon */
    public final int x, y, r;
    public Cercle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
