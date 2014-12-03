
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
        Turtle.keyPressed(e.getKeyCode());
    }
}
