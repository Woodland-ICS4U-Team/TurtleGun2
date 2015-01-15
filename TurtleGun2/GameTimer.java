import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

public class GameTimer extends TimerTask {
    Level level;
    
    public GameTimer(Level temp) {
        level = temp;
    }
    
    public void run() {
        level.run();
        level.repaint();
    }
}
