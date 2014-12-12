import javax.swing.JFrame;
import java.util.*;

public class TurtleGun2 extends JFrame{
    private static int FRAMES_PER_SECOND = 30;
    private static int LEVEL_WIDTH = 1280;
    private static int LEVEL_HEIGHT = 720;
    Level stage = new Level();
    //The GameTimer is given the stage so that it can call the repaint method whenever the stage moves
    GameTimer timer = new GameTimer(stage);
    Timer gameSchedule = new Timer();

    public TurtleGun2() {
        TurtleGun2 frame = new TurtleGun2();
        gameSchedule.schedule(frame.getTimer(), 0, 1000 / FRAMES_PER_SECOND);
        frame.add(stage);
    }
    
    public static void main() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(LEVEL_WIDTH, LEVEL_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
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