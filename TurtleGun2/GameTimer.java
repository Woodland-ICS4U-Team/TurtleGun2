
import java.util.*;

public class GameTimer extends TimerTask {
    Level level = new Level();
    
    public void run() {
        level.run();
        System.out.println("Run run");
    }
}
