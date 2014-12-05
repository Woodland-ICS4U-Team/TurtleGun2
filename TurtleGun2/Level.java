
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
   
    public Level() {
        addKeyListener(new KeyListener());
        System.out.println("added key listener");
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D graphics = (Graphics2D)g;
        graphics.drawString("Does it work?", 5, 15);
        graphics.drawImage(Turtle.getImage(), Turtle.getX(), Turtle.getY(), this);
        g.dispose();
    }
    
    public void actionPerformed(ActionEvent e) {
        repaint();
        
    }
}
