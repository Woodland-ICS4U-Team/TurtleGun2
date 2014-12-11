
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level extends JPanel {
    private Turtle franklin = new Turtle();
    private Narwhal narwhal = new Narwhal();
    private Obstacle obstacles = new Obstacle();
    private Piranha nemo = new Piranha(5, 8);
    
    public Level() {
        addKeyListener(new KeyListener());
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D)g;
        graphics.drawImage(franklin.getImage(), franklin.getX(), franklin.getY(), this);
        graphics.drawImage(narwhal.getImage(), narwhal.getX(), narwhal.getY(), this);
        graphics.drawImage(nemo.getImage(), nemo.getX(), nemo.getY(), this);
        g.dispose();
    }
    
    public void run() {
        repaint();
        narwhal.move();
        System.out.println("Actionperformed called");
    }
}
