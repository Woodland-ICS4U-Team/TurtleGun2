import javax.swing.JFrame;
import java.util.*;

public class Main extends JFrame{
    int FRAMES_PER_SECOND = 30;
    Level stage = new Level();
    //The GameTimer is given the stage so that it can call the repaint method whenever the stage moves
    GameTimer timer = new GameTimer(stage);
    Timer gameSchedule = new Timer();
    
    public void main() {
        gameSchedule.schedule(timer, 0, 1000 / FRAMES_PER_SECOND);
        JFrame frame = new JFrame("Turtle Gun II");
        frame.add(stage);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}