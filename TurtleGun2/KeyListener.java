
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    private Level level;

    public void keyPressed(KeyEvent e) {
        level.keyPressed(e.getKeyCode(), level);
    }
    
    public void keyReleased(KeyEvent e) {
        level.keyReleased(e.getKeyCode());
    }
    
    public KeyListener(Level l) {
        level = l;
    }
}
