
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level extends JPanel implements ActionListener {
    
    private Turtle franklin = new Turtle();
    private Narwhal narwhal = new Narwhal();
    
    public Level() {
        addKeyListener(new KeyListener());
        System.out.println("added key listener");      
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics = (Graphics2D)g;
        graphics.drawImage(franklin.getImage(), franklin.getX(), franklin.getY(), this);
        graphics.drawImage(narwhal.getImage(), narwhal.getX(), narwhal.getY(), this);
        g.dispose();
    }
    
    public void actionPerformed(ActionEvent e) {
        repaint();
        narwhal.move();
        System.out.println("Actionperformed called");
    }
}
