
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Piranha {
    //Constants
    private int MAX_SHOTS = 20;
    private final int BOARD_WIDTH = 1280;
    private final int MISSILE_SPEED = 2;
    
    //Prianha constructs
    private String prianhaImage = "Piranha.png";
    private int x, y;
    private Image image;
    private boolean visible;
    private int width, height;
    private int piranhaX[] = new int[MAX_SHOTS];
    private int piranhaY[] = new int[MAX_SHOTS];    
    private boolean piranhaVisible[] = new boolean[MAX_SHOTS];
    private Image[] piranhaImages = new Image[MAX_SHOTS];

    //Keeps track of prianhas fired
    private int i = 0;
    private int hit = 0;
    private int obstacleDestroyed = 0;
    public Piranha() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(prianhaImage));
        image = ii.getImage();
    }
    
    public Image getImage() {
        return image;
    }
    // the X value of the piranha
    public int getX(int i) {
        return piranhaX[i];
    }
    // the Y value of the piranha
    public int getY(int i) {
        return piranhaY[i];
    }
    //How many shots you can have
    public int getNumPiranhas() {
        return MAX_SHOTS;
    }
    //used to tell if the piranha is shot and the piranha is visible
    public boolean getVisible(int piranhaNumber) {
        return piranhaVisible[piranhaNumber];
    }
    //used to reset the number of shots
    public void reset(){
        i = 0;
    }
    public int getObstaclesDestroyed() {
        return obstacleDestroyed;
    }
    // when this is called piranha[i] will be set true and will appear in the game, starting where the turtle is
    public void addPiranha(int x, int y) {
        for (int z = 0; z < MAX_SHOTS; z++) {
            if (!piranhaVisible[z]) {
                i = z;
            }
        }
        piranhaVisible[i] = true;
        piranhaImages[i] = image;
        piranhaY[i] = y;
        piranhaX[i] = x;
        i++;
    }
    
    public void addToInventory(){
        i --;
    }
    
    // collision detection for piranha 
    public void move(int speed, Obstacle obstacle) {
        
        for (int i = 0; i < MAX_SHOTS; i++) {
            if (piranhaVisible[i]) {
                hit = obstacle.checkCollisions(getX(i), getY(i), getImage().getWidth(null), getImage().getHeight(null));
                if (hit != -1) { //hit = -1 if obstacle is hit, so it hides the obstacle and the piranha
                    obstacle.removeObstacle(obstacle.checkCollisions(getX(i), getY(i), getImage().getWidth(null), getImage().getHeight(null)));
                    piranhaVisible[i] = false;
                    obstacleDestroyed++;
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