
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    
    private Turtle franklin;
    //private Narwhal narwhal = new Narwhal();
    //private Piranha nemo = new Piranha(5, 8);
    public void keyPressed(KeyEvent e) {
        franklin.keyPressed(e.getKeyCode());
    }
    
    public void keyReleased(KeyEvent e) {
        franklin.keyReleased(e.getKeyCode());
    }
    
    public KeyListener(Turtle t) {
        franklin = t;
    }
}
