import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Obstacle {
    
    private int NUM_IMAGES = 3;
    private int MAX_OBJECTS = 10;
    private int STARTING_Y = 1000;
    private int MAX_STARTING_X = 1000;
    private int MIN_STARTING_X = 100;
    private Image[] objectImages = new Image[NUM_IMAGES];
    private int numObjects = 0;
    //Object tables
    private Image objectImage[] = new Image[MAX_OBJECTS];
    private int objectX[] = new int[MAX_OBJECTS];
    private int objectY[] = new int[MAX_OBJECTS];
    private boolean objectVisible[] = new boolean [MAX_OBJECTS];
    
    public Obstacle() {
        ImageIcon one = new ImageIcon(this.getClass().getResource("narwal.png"));
        objectImages[0] = one.getImage();
        ImageIcon two = new ImageIcon(this.getClass().getResource("narwal.png"));
        objectImages[1] = two.getImage();
        ImageIcon three = new ImageIcon(this.getClass().getResource("narwal.png"));
        objectImages[2] = three.getImage();
    }
    
    public void addObstacle() {
        boolean foundObstacle = false;
        for (int i = 0; (i < MAX_OBJECTS) && (foundObstacle == false); i ++) {
            if (objectVisible[MAX_OBJECTS]) {
                Random number = new Random();
                objectVisible[i] = true;
                objectImage[i] = objectImages[number.nextInt(NUM_IMAGES)];
                objectX[i] = number.nextInt(MAX_STARTING_X - MIN_STARTING_X) + MIN_STARTING_X;
                objectY[i] = STARTING_Y;
                foundObstacle = true;
            }
        }
    }
    
    public void moveObjects(int distance) {
        for (int i = 0; i < MAX_OBJECTS; i ++) {
            if (objectVisible[i] == true) {
                objectX[i] -= 10;
            }
        }
    }
    
    public int getX(int objectNumber) {
        return objectX[objectNumber];
    }
    
    public int getY(int objectNumber) {
        return objectY[objectNumber];
    }
}