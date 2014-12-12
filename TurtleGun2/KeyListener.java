
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    
    private Turtle franklin;
    //private Narwhal narwhal = new Narwhal();
    //private Piranha nemo = new Piranha(5, 8);
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
        franklin.keyPressed(e.getKeyCode());
    }
    public KeyListener(Turtle t) {
        franklin = t;
    }
}
