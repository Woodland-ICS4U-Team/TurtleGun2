
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class Level extends JPanel {
    private Turtle franklin = new Turtle();
    private Narwhal narwhal = new Narwhal();
    private Obstacle obstacles = new Obstacle();
    private Piranha nemo = new Piranha(5, 8);
    private int levelSpeed = 5;
    
    public Level() {
        addKeyListener(new KeyListener());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics = (Graphics2D)g;
        
        graphics.drawImage(franklin.getImage(), franklin.getX(), franklin.getY(), this);
        graphics.drawImage(narwhal.getImage(), narwhal.getX(), narwhal.getY(), this);
        graphics.drawImage(nemo.getImage(), nemo.getX(), nemo.getY(), this);
        
        //Draw all of the obstacles if they are visible
        for (int i = 0; i < obstacles.getNumObstacles(); i++) {
            if (obstacles.getVisible(i)) {
               graphics.drawImage(obstacles.getImage(i), obstacles.getX(i), obstacles.getY(i), this);
            }
        }
        
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    public void run() {
        narwhal.move();
        obstacles.addObstacle();
        obstacles.moveObstacles(levelSpeed);
    }
}
