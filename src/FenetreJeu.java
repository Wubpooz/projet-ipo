import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FenetreJeu extends JPanel implements KeyListener {
    private Terrain terrain;
    private int tailleCase = 24;
    private int hauteur, largeur;
    private JFrame frame;

    private int viej=0;

    public FenetreJeu(Terrain t) {
        this.hauteur = t.getHauteur();
        this.largeur = t.getLargeur();
        this.terrain = t;

        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(largeur * tailleCase, hauteur * tailleCase));

        JFrame frame = new JFrame("Donjon");
        this.frame = frame;
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);



    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Case[][] carte = terrain.getCarte();
        for (int i=0;i<hauteur;i++){
            for(int j=0;j<largeur;j++){
                if(carte[i][j] instanceof CaseIntraversable) {
                    g.setColor(new Color(242,186,201));
                    g.fillRect(j*24, i * 24, 24, 24);
                } else if (((CaseTraversable)carte[i][j]).getContenu() instanceof Obstacle) {
                    g.setColor(new Color(238, 171, 13));
                    g.fillRect(j*24, i * 24, 24, 24);
                } else if (((CaseTraversable)carte[i][j]) instanceof Sortie) {
                    g.setColor(new Color(223, 13, 238));
                    g.fillRect(j*24, i * 24, 24, 24);
                } else if (((CaseTraversable)carte[i][j]).getContenu() instanceof Personnage) {
                    g.setColor(new Color(184, 238, 155));
                    g.fillRect(j*24, i * 24, 24, 24);
                } else if (((CaseTraversable)carte[i][j]).getContenu() instanceof Monstre) {
                    g.setColor(new Color(229, 26, 26));
                    g.fillRect(j*24, i * 24, 24, 24);
                } else if (((CaseTraversable)carte[i][j]).getContenu() instanceof Joueur) {
                    g.setColor(new Color(32,170,200));
                    g.fillRect(j*24, i * 24, 24, 24);
                    viej = ((CaseTraversable)carte[i][j]).getContenu().getResistance();
                    terrain.joueurStatut(false, ((CaseTraversable)carte[i][j]).getContenu().getResistance()); // tue le joueur si il a pris trop de dégats
                }
            }
        }

        g.setFont(new Font("Verdana", 1, 20));
        g.setColor(Color.RED);
        g.drawString("❤️".repeat(viej),27,18);

    }

    public void ecranFinal(int n) {
        frame.remove(this);
        JLabel label = new JLabel("Score " + n);
        label.setFont(new Font("Verdana", 1, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setSize(this.getSize());
        frame.getContentPane().add(label);
        frame.repaint();
    }


    @Override
    public void keyPressed(KeyEvent key) {
        Case[][] carte = terrain.getCarte();
        for (int i=0;i<hauteur;i++){
            for(int j=0;j<largeur;j++){
                if(carte[i][j] instanceof CaseTraversable &&( ((CaseTraversable) carte[i][j]).getContenu() instanceof Joueur)){
                    Joueur Jou = (Joueur) ((CaseTraversable) carte[i][j]).getContenu();

                    switch (key.getKeyCode()){
                        case KeyEvent.VK_LEFT : Jou.avance((CaseTraversable) carte[i][j], carte[i][j-1]);break;
                        case KeyEvent.VK_UP : Jou.avance((CaseTraversable) carte[i][j], carte[i-1][j]);break;
                        case KeyEvent.VK_RIGHT: Jou.avance((CaseTraversable) carte[i][j],carte[i][j+1]);break;
                        case KeyEvent.VK_DOWN: Jou.avance((CaseTraversable) carte[i][j],carte[i+1][j]);break;
                        case KeyEvent.VK_SPACE : terrain.joueurStatut(Jou.sors((CaseTraversable) carte[i][j]),Jou.getResistance());break;  //sors le joueur si il est pas mort d'abord
                    }
                    i=hauteur;
                    j=largeur;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent key) { }
    @Override
    public void keyReleased(KeyEvent key) { }
}
