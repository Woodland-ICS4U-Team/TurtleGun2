
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Piranha {
    //Constants
    private int MAX_SHOTS = 15;
    private final int BOARD_WIDTH = 1280;
    private final int MISSILE_SPEED = 2;
    
    //related to the physical image of the piranha
    private String prianhaImage = "Piranha.png";
    private int x, y;
    private Image image;
    private boolean visible;
    private int width, height;
    private int piranhaX[] = new int[MAX_SHOTS];
    private int piranhaY[] = new int[MAX_SHOTS];    
    private boolean piranhaVisible[] = new boolean[15];
    private Image[] piranhaImages = new Image[15];

    //Shot related
    private int i = 0;
    private int hit = 0;
    private int shotsLeft = MAX_SHOTS;
    public Piranha() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(prianhaImage));
        image = ii.getImage();
    }
    
    public Image getImage() {
        return image;
    }
    //accessor for the X value of the piranha
    public int getX(int i) {
        return piranhaX[i];
    }
    //accessor for the Y value of the piranha
    public int getY(int i) {
        return piranhaY[i];
    }
    //accessor to get the maximum shots allowed in a game
    public int getNumPiranhas() {
        return MAX_SHOTS;
    }
    //used to tell if the piranha is shot and the piranha is visible
    public boolean getVisible(int piranhaNumber) {
        return piranhaVisible[piranhaNumber];
    }
    //used to resset the number of shots
    public void reset(){
        i = 0;
    }
    // when this is called piranha[i] will be set true and will appear in the game, starting where the turtle is
    public void addPiranha(int x, int y) {
        if (!piranhaVisible[i]) {
            piranhaVisible[i] = true;
            piranhaImages[i] = image;
            piranhaY[i] = y;
            piranhaX[i] = x;
            i++;
        }
    }
    // moved the piraha across the screen for every shot piranha, and checks collision detection
    public void move(int speed, Obstacle obstacle) {
        
        for (int i = 0; i < MAX_SHOTS; i++) {
            if (piranhaVisible[i]) {
                hit = obstacle.checkCollisions(getX(i), getY(i), getImage().getWidth(null), getImage().getHeight(null));
                if (hit != -1) { //hit = -1 if obstacle is hit, so it hides the obstacle and the piranha
                    obstacle.hideObstacle(obstacle.checkCollisions(getX(i), getY(i), getImage().getWidth(null), getImage().getHeight(null)));
                    piranhaVisible[i] = false;
                }
                // moves piranha at desired speed
                piranhaX[i] += speed; 
                // if piranha has reached the end of the board without hitting anything, makes it invisible
                if (piranhaX[i] > BOARD_WIDTH) 
                    piranhaVisible[i] = false;
            }
        }
        
    } 
}