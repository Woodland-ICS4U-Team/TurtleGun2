import javax.swing.JFrame;
import java.util.*;

public class TurtleGun2 extends JFrame{
    private static int FRAMES_PER_SECOND = 30;
    private static int LEVEL_WIDTH = 1280;
    private static int LEVEL_HEIGHT = 720;
    private static Level stage = new Level();
    private static GameTimer timer = new GameTimer(stage);
    private static Timer gameSchedule = new Timer();
    
    public static void main() {
        new TurtleGun2();
    }
    
    public TurtleGun2() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(LEVEL_WIDTH, LEVEL_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        gameSchedule.schedule(getTimer(), 0, 1000 / FRAMES_PER_SECOND);
        add(stage);
    }
    
    public GameTimer getTimer() {
        return timer;
    }
    
    public static int getLevelHeight() {
        return LEVEL_HEIGHT;
    }
    
    public static int getLevelWidth() {
        return LEVEL_WIDTH;
    }
}