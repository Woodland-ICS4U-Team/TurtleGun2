
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    
    private Turtle franklin = new Turtle();
    private Narwhal narwhal = new Narwhal();
    
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
        franklin.keyPressed(e.getKeyCode());
    }
}
