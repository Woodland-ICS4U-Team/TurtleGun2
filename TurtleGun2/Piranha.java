
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

    public int getX(int i) {
        return piranhaX[i];
    }

    public int getY(int i) {
        return piranhaY[i];
    }
    public int getNumPiranhas() {
        return MAX_SHOTS;
    }
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    public boolean getVisible(int piranhaNumber) {
        return piranhaVisible[piranhaNumber];
    }
    public void addPiranha(int x, int y) {
        if (!piranhaVisible[i]) {
            piranhaVisible[i] = true;
            piranhaImages[i] = image;
            piranhaY[i] = y;
            piranhaX[i] = x;
            i++;
        }
    }
    public void move(int speed, Obstacle obstacle) {
        
        for (int i = 0; i < MAX_SHOTS; i++) {
            if (piranhaVisible[i]) {
                hit = obstacle.checkCollisions(getX(i), getY(i), getImage().getWidth(null), getImage().getHeight(null));
                if (hit != -1) {
                    obstacle.hideObstacle(obstacle.checkCollisions(getX(i), getY(i), getImage().getWidth(null), getImage().getHeight(null)));
                    piranhaVisible[i] = false;
                }
                piranhaX[i] += speed;
                if (piranhaX[i] > BOARD_WIDTH)
                    piranhaVisible[i] = false;
            }
        }
        
    } 
}