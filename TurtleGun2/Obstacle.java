import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Obstacle {

//----------------------------------------------------------------------------------------
//----------------------------------------variables---------------------------------------
//----------------------------------------------------------------------------------------
    //constants
    private int STARTING_OBSTACLE_PROBABILITY = 10;
    private int NUM_IMAGES = 3;
    private int MAX_OBSTACLES = 10;
    private int OBSTACLE_WIDTH = 100;
    private int OBSTACLE_HEIGHT = 100;
    private int STARTING_X = TurtleGun2.getLevelWidth();
    private int MAX_STARTING_Y = TurtleGun2.getLevelHeight();
    private int MIN_STARTING_Y = OBSTACLE_HEIGHT;
    
    //obstacle tables
    private Image obstacleImage[] = new Image[MAX_OBSTACLES];
    private int obstacleX[] = new int[MAX_OBSTACLES];
    private int obstacleY[] = new int[MAX_OBSTACLES];
    private boolean obstacleVisible[] = new boolean [MAX_OBSTACLES];
    private Image[] obstacleImages = new Image[NUM_IMAGES];
    
    //internal variables
    private Random number = new Random();
    private int obstacleProbability = STARTING_OBSTACLE_PROBABILITY;

//----------------------------------------------------------------------------------------
//---------------------------------------constructor--------------------------------------
//----------------------------------------------------------------------------------------
 
    public Obstacle() {
        ImageIcon one = new ImageIcon(this.getClass().getResource("Obstacle1.png"));
        obstacleImages[0] = one.getImage();
        ImageIcon two = new ImageIcon(this.getClass().getResource("Obstacle1.png"));
        obstacleImages[1] = two.getImage();
        ImageIcon three = new ImageIcon(this.getClass().getResource("Obstacle1.png"));
        obstacleImages[2] = three.getImage();
    }

//----------------------------------------------------------------------------------------
//-----------------------------------------methods----------------------------------------
//----------------------------------------------------------------------------------------

    public void addObstacle() {
        if (number.nextInt(obstacleProbability) == 1) {
            for (int i = 0; (i < MAX_OBSTACLES); i ++) {
                if (!obstacleVisible[i]) {
                    obstacleVisible[i] = true;
                    obstacleImage[i] = obstacleImages[number.nextInt(NUM_IMAGES)];
                    obstacleY[i] = number.nextInt(MAX_STARTING_Y - MIN_STARTING_Y) + MIN_STARTING_Y;
                    obstacleX[i] = STARTING_X;
                    return;
                }
            }
        }
    }
    
    public void removeObstacle(int obstacleNumber) {
        if ((obstacleNumber >= 0) && (obstacleNumber< MAX_OBSTACLES)) {
            obstacleVisible[obstacleNumber] = false;
        }
    }
    
    public void moveObstacles(int distance) {
        for (int i = 0; i < MAX_OBSTACLES; i ++) {
            if (obstacleVisible[i]) {
                obstacleX[i] -= distance;
                if (obstacleX[i] < -OBSTACLE_WIDTH) {
                    obstacleVisible[i] = false;
                }
            }
        }
    }
    
    //Returns -1 if there is not collision, and the object number if it hit one
    public int checkCollisions(int thingX, int thingY, int thingWidth, int thingHeight) {
        for (int i = 0; i < MAX_OBSTACLES; i ++) {
            if (obstacleVisible[i]) {
                if ((obstacleX[i] + 10 < thingX + thingWidth) && (obstacleX[i] - 10 + OBSTACLE_WIDTH > thingX)) {
                    if ((obstacleY[i] + 10 < thingY + thingHeight) && (obstacleY[i] - 10 + OBSTACLE_WIDTH > thingY)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    
//----------------------------------------------------------------------------------------
//-----------------------------------------getters----------------------------------------
//----------------------------------------------------------------------------------------
    
    public Image getImage(int obstacleNumber) {
        return obstacleImage[obstacleNumber];
    }
    
    public int getNumObstacles() {
        return MAX_OBSTACLES;
    }
    
    public boolean getVisible(int obstacleNumber) {
        return obstacleVisible[obstacleNumber];
    }
    
    public int getX(int obstacleNumber) {
        return obstacleX[obstacleNumber];
    }
    
    public int getY(int obstacleNumber) {
        return obstacleY[obstacleNumber];
    }
}