import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FenetreJeu extends JPanel implements KeyListener {
    private Terrain terrain;
    private int tailleCase = 24;
    private int hauteur, largeur;
    private JFrame frame;

    private final BufferedImage door;
    private final BufferedImage wall;
    private final BufferedImage barrel;
    private final BufferedImage sheep_side;
    private final BufferedImage wolf;
    private final BufferedImage shepherd;
    private int viej=0;

    public FenetreJeu(Terrain t) throws IOException {
        this.hauteur = t.getHauteur();
        this.largeur = t.getLargeur();
        this.terrain = t;

        this.door = ImageIO.read(new File("assets/door.png"));
        this.wall = ImageIO.read(new File("assets/wall.png"));
        this.barrel = ImageIO.read(new File("assets/barrel.png"));
        this.sheep_side = ImageIO.read(new File("assets/sheep_side.png"));
        this.wolf = ImageIO.read(new File("assets/wolf.png"));
        this.shepherd = ImageIO.read(new File("assets/shepherd.png"));


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
                    /*g.setColor(new Color(242,186,201));
                    g.fillRect(j*24, i * 24, 24, 24);*/
                    g.drawImage(wall,j*24,i*24,24,24,null);
                } else if (((CaseTraversable)carte[i][j]).getContenu() instanceof Obstacle) {
                    /*g.setColor(new Color(238, 171, 13));
                    g.fillRect(j*24, i * 24, 24, 24);
                    g.setColor(Color.black);
                    g.drawRect(j*24,i*24,24,24);*/
                    g.drawImage(barrel,j*24,i*24,24,24,null);
                } else if (((CaseTraversable)carte[i][j]) instanceof Sortie) {
                    /*g.setColor(new Color(223, 13, 238));
                    g.fillRect(j*24, i * 24, 24, 24);*/
                    g.drawImage(door,i*24,j*24,24,24,null);
                } else if (((CaseTraversable)carte[i][j]).getContenu() instanceof Personnage) {
                    /*g.setColor(new Color(184, 238, 155));
                    g.fillOval(j*24, i * 24, 24, 24);*/
                    g.drawImage(sheep_side,j*24,i*24,24,24,null);
                } else if (((CaseTraversable)carte[i][j]).getContenu() instanceof Monstre) {
                    /*g.setColor(new Color(229, 26, 26));
                    g.fillRect(j*24, i * 24, 24, 24);*/
                    g.drawImage(wolf,j*24,i*24,24,24,null);
                } else if (((CaseTraversable)carte[i][j]).getContenu() instanceof Joueur) {
                    /*g.setColor(new Color(32,170,200));
                    g.fillOval(j*24, i * 24, 24, 24);*/
                    g.drawImage(shepherd,j*24,i*24,24,24,null);

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
                        case KeyEvent.VK_Q : Jou.damage(carte[i][j-1]);break;       //allow player to damage monsters
                        case KeyEvent.VK_Z : Jou.damage(carte[i-1][j]);break;
                        case KeyEvent.VK_D: Jou.damage(carte[i][j+1]);break;
                        case KeyEvent.VK_S: Jou.damage(carte[i+1][j]);break;
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
