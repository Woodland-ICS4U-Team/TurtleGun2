import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class morePiranhas {
    
    private int IMAGE_WIDTH = 50;
    private int IMAGE_HEIGHT = 25;
    private int STARTING_X = TurtleGun2.getLevelWidth();
    private int MAX_STARTING_Y = TurtleGun2.getLevelHeight() - IMAGE_HEIGHT - 80;
    private int MIN_STARTING_Y = 0;
    
    private boolean obstacleVisible[] = new boolean [1];
    private boolean obstacleHit[] = new boolean [1];
    private Image piranhaImage[] = new Image[1];
    
    private Random number = new Random();
    
    public morePiranhas() {
        ImageIcon one = new ImageIcon(this.getClass().getResource("Piranha1.png"));
        piranhaImage[0] = one.getImage();
    }
}