import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Obstacle {

//----------------------------------------------------------------------------------------
//----------------------------------------variables---------------------------------------
//----------------------------------------------------------------------------------------
    //constants
    private double DIFFICULTY_INCREACE = 0.3;
    private int OBSTACLE_PROBABILITY = 100;
    private int NUM_IMAGES = 3;
    private int MAX_OBSTACLES = 20;
    private int MAX_DIFFICULTY = 15;
    //This is the minimum at difficulty 1, but it changes as the difficulty increaces
    private int MIN_OBSTACLE_DISTANCE = 400;
    private int OBSTACLE_WIDTH = 100;
    private int OBSTACLE_HEIGHT = 100;
    private int STARTING_X = TurtleGun2.getLevelWidth();
    private int MAX_STARTING_Y = TurtleGun2.getLevelHeight() - OBSTACLE_HEIGHT - 80;
    private int MIN_STARTING_Y = 0;
    
    //obstacle arrays
    private Image obstacleImage[] = new Image[MAX_OBSTACLES];
    private int obstacleX[] = new int[MAX_OBSTACLES];
    private int obstacleY[] = new int[MAX_OBSTACLES];
    private double difficulty = 1;
    private boolean obstacleVisible[] = new boolean [MAX_OBSTACLES];
    private boolean obstacleHit[] = new boolean [MAX_OBSTACLES];
    private Image[] obstacleImages = new Image[NUM_IMAGES];
    
    //internal variables
    private Random number = new Random();

//----------------------------------------------------------------------------------------
//---------------------------------------constructor--------------------------------------
//----------------------------------------------------------------------------------------
 
    public Obstacle() {
        difficulty = 1;
        ImageIcon one = new ImageIcon(this.getClass().getResource("Obstacle1.png"));
        obstacleImages[0] = one.getImage();
        ImageIcon two = new ImageIcon(this.getClass().getResource("Obstacle2.png"));
        obstacleImages[1] = two.getImage();
        ImageIcon three = new ImageIcon(this.getClass().getResource("Obstacle3.png"));
        obstacleImages[2] = three.getImage();
    }

//----------------------------------------------------------------------------------------
//-----------------------------------------methods----------------------------------------
//----------------------------------------------------------------------------------------

    public void addObstacle() {
        //When difficulty increaces, the obstacles move closer together and there is a greater chance of them spawning
        for (int i = 0; (i < MAX_OBSTACLES); i ++) {
            if (!obstacleVisible[i]) {
                int x = STARTING_X;
                int y = number.nextInt(MAX_STARTING_Y - MIN_STARTING_Y) + MIN_STARTING_Y;
                if (canPlaceObstacle(x, y)) {
                    if (difficulty < MAX_DIFFICULTY) {
                        difficulty += DIFFICULTY_INCREACE;
                    }
                    obstacleVisible[i] = true;
                    obstacleHit[i] = false;
                    obstacleImage[i] = obstacleImages[number.nextInt(NUM_IMAGES)];
                    obstacleY[i] = y;
                    obstacleX[i] = x;
                    return;
                }
            }
        }
    }
    
    public void removeObstacle(int obstacleNumber) {
        if ((obstacleNumber >= 0) && (obstacleNumber < MAX_OBSTACLES)) {
            obstacleHit[obstacleNumber] = true;
        }
    }
    
    public void hideObstacle(int obstacleNumber) {
        if ((obstacleNumber >= 0) && (obstacleNumber < MAX_OBSTACLES)) {
            obstacleVisible[obstacleNumber] = false;
            obstacleHit[obstacleNumber] = true;
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
    
    //Returns -1 if there is not collision, and the object it hit if there is
    public int checkCollisions(int thingX, int thingY, int thingWidth, int thingHeight) {
        for (int i = 0; i < MAX_OBSTACLES; i ++) {
            if (!obstacleHit[i]) {
                if ((obstacleX[i] + 10 < thingX + thingWidth) && (obstacleX[i] - 10 + OBSTACLE_WIDTH > thingX)) {
                    if ((obstacleY[i] + 10 < thingY + thingHeight) && (obstacleY[i] - 10 + OBSTACLE_WIDTH > thingY)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean canPlaceObstacle(int x, int y) {
        if (number.nextInt(OBSTACLE_PROBABILITY) == 1) {
            int objX;
            int objY;
            double distance;
            for (int i = 0; i < MAX_OBSTACLES; i++) {
                if (obstacleVisible[i] == true) {
                    objX = obstacleX[i];
                    objY = obstacleY[i];
                    distance = Math.sqrt(Math.pow((objX - x), 2) + Math.pow((objY - y), 2));
                    if (distance < (MIN_OBSTACLE_DISTANCE - ((difficulty) * 20))) {
                        return false;
                    }
                }
            }
            System.out.println("can place obstacle");
            return true;
        }
        return false;
    }
    
    //Called by the Level class when the game is restarted, so all the variables need to be reset
    public void reset() {
        obstacleImage = new Image[MAX_OBSTACLES];
        obstacleX = new int[MAX_OBSTACLES];
        obstacleY = new int[MAX_OBSTACLES];
        difficulty = 1;
        obstacleVisible = new boolean [MAX_OBSTACLES];
        obstacleHit = new boolean [MAX_OBSTACLES];
        obstacleImages = new Image[NUM_IMAGES];
        difficulty = 1;
        ImageIcon one = new ImageIcon(this.getClass().getResource("Obstacle1.png"));
        obstacleImages[0] = one.getImage();
        ImageIcon two = new ImageIcon(this.getClass().getResource("Obstacle2.png"));
        obstacleImages[1] = two.getImage();
        ImageIcon three = new ImageIcon(this.getClass().getResource("Obstacle3.png"));
        obstacleImages[2] = three.getImage();
    }
    
//----------------------------------------------------------------------------------------
//------------------------------------getters & setters-----------------------------------
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