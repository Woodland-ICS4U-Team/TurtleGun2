//Obstacle class in TurtleGun2
//Contains information and movement methods for the different obstacles in the game
//Coded by Jacob Brunsting
//Commented by Caleb Isaacs
//15/1/2015

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Obstacle {

//----------------------------------------------------------------------------------------
//----------------------------------------variables---------------------------------------
//----------------------------------------------------------------------------------------
    //Constants
    private double DIFFICULTY_INCREACE = 0.2;
    //Determines how often the game will try to place an obstacle, the lower the more often
    private int OBSTACLE_PROBABILITY = 100;
    private int NUM_IMAGES = 3;
    private int NUM_BLOOD = 4;
    private int MAX_OBSTACLES = 20;
    private int MAX_DIFFICULTY = 13;
    //This is the minimum distance between the obstacles at difficulty level 1, but it decreaces as the difficulty increaces
    private int MIN_OBSTACLE_DISTANCE = 400;
    private int STARTING_X = TurtleGun2.getLevelWidth();
    private int MAX_STARTING_Y = TurtleGun2.getLevelHeight() - 180;
    private int MIN_STARTING_Y = 0;
    
    //Obstacle arrays
    private Image obstacleImage[] = new Image[MAX_OBSTACLES];
    private int obstacleX[] = new int[MAX_OBSTACLES];
    private int obstacleY[] = new int[MAX_OBSTACLES];
    private boolean obstacleVisible[] = new boolean [MAX_OBSTACLES];
    private boolean obstacleHit[] = new boolean [MAX_OBSTACLES];
    
    //Internal variables
    //Two arrays that contain all of the possible images for the obstacles
    private Image obstacleImages[] = new Image[NUM_IMAGES];
    private Image bloodCloud[] = new Image[NUM_BLOOD];
    //The higher the difficulty, the closer the obstacles can spawn to eachother
    private double difficulty = 1;
    private Random number = new Random();

//----------------------------------------------------------------------------------------
//---------------------------------------constructor--------------------------------------
//----------------------------------------------------------------------------------------
 
    public Obstacle() {
        difficulty = 1;
        //Create two arrays of images, that 
        obstacleImages[0] = (new ImageIcon(this.getClass().getResource("Obstacle1.png"))).getImage();
        obstacleImages[1] = (new ImageIcon(this.getClass().getResource("Obstacle2.png"))).getImage();
        obstacleImages[2] = (new ImageIcon(this.getClass().getResource("Obstacle3.png")).getImage());
        bloodCloud[0] = (new ImageIcon(this.getClass().getResource("Blood1.png"))).getImage();
        bloodCloud[1] = (new ImageIcon(this.getClass().getResource("Blood2.png"))).getImage();
        bloodCloud[2] = (new ImageIcon(this.getClass().getResource("Blood3.png"))).getImage();
        bloodCloud[3] = (new ImageIcon(this.getClass().getResource("Blood4.png"))).getImage();
    }

//----------------------------------------------------------------------------------------
//-----------------------------------------methods----------------------------------------
//----------------------------------------------------------------------------------------
    //This function is called several times per second by the run method of the Level class, and decides whether to place an obstacle
    public void addObstacle() {
        //The lower OBSTACLE_PROBABILITY is, the more likely an obstacle is to spawn
        if (number.nextInt(OBSTACLE_PROBABILITY) == 1) {
            //When difficulty increaces, the obstacles move closer together
            for (int i = 0; (i < MAX_OBSTACLES); i ++) {
                //Search for obstacles that are off the screen
                if (!obstacleVisible[i]) {
                    //Generate a starting position for the obstacle
                    int x = STARTING_X;
                    int y = number.nextInt(MAX_STARTING_Y - MIN_STARTING_Y) + MIN_STARTING_Y;
                    //If an obstacle can be spawned at the generated coordinates, spawn it
                    if (canPlaceObstacle(x, y)) {
                        //Increace the difficulty when an obstacle is created
                        if (difficulty < MAX_DIFFICULTY) {
                            difficulty += DIFFICULTY_INCREACE;
                        }
                        //Create the obstacle by filling in all of the arrays
                        obstacleVisible[i] = true;
                        obstacleHit[i] = false;
                        obstacleImage[i] = obstacleImages[number.nextInt(NUM_IMAGES)];
                        obstacleY[i] = y;
                        obstacleX[i] = x;
                        //End the function when an obstacle has been created
                        return;
                    }
                }
            }
        }
    }
    
    //This function turns off collision detection for the obstacle, and replaces the image with blood
    public void removeObstacle(int obstacleNumber) {
        if ((obstacleNumber >= 0) && (obstacleNumber < MAX_OBSTACLES)) {
            obstacleHit[obstacleNumber] = true;
            obstacleImage[obstacleNumber] = bloodCloud[number.nextInt(NUM_BLOOD)];
        }
    }
    
    //Removes hit detection for the obstacle and hides it
    public void hideObstacle(int obstacleNumber) {
        if ((obstacleNumber >= 0) && (obstacleNumber < MAX_OBSTACLES)) {
            obstacleVisible[obstacleNumber] = false;
            obstacleHit[obstacleNumber] = true;
        }
    }
    
    //Moves all the obstacles a certain distance, called by the run method of the Level class several times per second
    public void moveObstacles(int distance) {
        //For all of the obstacles
        for (int i = 0; i < MAX_OBSTACLES; i ++) {
            //Move them if they are visible
            if (obstacleVisible[i]) {
                obstacleX[i] -= distance;
                //If they are off the screen, hide them
                if (obstacleX[i] < -obstacleImage[i].getWidth(null)) {
                    obstacleVisible[i] = false;
                }
            }
        }
    }
    
    //This function checks if an object with certain coordinates and dimensions has hit an obstacle
    //Returns -1 if there is not collision
    //If there is a collision, it returns the number of the obstacle that has been hit
    public int checkCollisions(int thingX, int thingY, int thingWidth, int thingHeight) {
        //For all of the obstacles
        for (int i = 0; i < MAX_OBSTACLES; i ++) {
            //If they are still visible, and hit detection is still enabled
            if (!obstacleHit[i] && obstacleVisible[i]) {
                //Check if the collision box for the obstacle overlaps the collision box provided in the function parameters
                if ((obstacleX[i] + 10 < thingX + thingWidth) && (obstacleX[i] - 10 + obstacleImage[i].getWidth(null) > thingX)) {
                    if ((obstacleY[i] + 10 < thingY + thingHeight) && (obstacleY[i] - 10 + obstacleImage[i].getHeight(null) > thingY)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    
    //Checks to see whether or not an obstacle can spawn in the provided coordinates
    private boolean canPlaceObstacle(int x, int y) {
        int objX;
        int objY;
        double distance;
        //Check each obstacle, and make sure it is not too close to each other
        for (int i = 0; i < MAX_OBSTACLES; i++) {
            if (obstacleVisible[i] == true) {
                objX = obstacleX[i];
                objY = obstacleY[i];
                //Use pythagorean theorem to determine the distance between the obstacles
                distance = Math.sqrt(Math.pow((objX - x), 2) + Math.pow((objY - y), 2));
                //If the distance between the obstacles is smaller than the minimum allowable distance, return false
                if (distance < (MIN_OBSTACLE_DISTANCE - ((difficulty) * 20))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    //Level calls this to reset all the variables
    public void reset() {
        //Reset all of the obstacle arrays
        obstacleImage = new Image[MAX_OBSTACLES];
        obstacleX = new int[MAX_OBSTACLES];
        obstacleY = new int[MAX_OBSTACLES];
        obstacleVisible = new boolean [MAX_OBSTACLES];
        obstacleHit = new boolean [MAX_OBSTACLES];
        obstacleImages = new Image[NUM_IMAGES];
        //Reset the difficulty
        difficulty = 1;
    }
    
//----------------------------------------------------------------------------------------
//------------------------------------getters & setters-----------------------------------
//----------------------------------------------------------------------------------------
    //Returns the image that is being used for a specific obstacle
    public Image getImage(int obstacleNumber) {
        return obstacleImage[obstacleNumber];
    }
    
    //Returns the maximum number of obstacles that can be on the screen at once
    public int getNumObstacles() {
        return MAX_OBSTACLES;
    }
    
    //Returns if the obstacle is visible
    public boolean getVisible(int obstacleNumber) {
        return obstacleVisible[obstacleNumber];
    }
    
    //Returns the x coordinate of the obstacle
    public int getX(int obstacleNumber) {
        return obstacleX[obstacleNumber];
    }
    
    //Returns the y coordinate of the obstacle
    public int getY(int obstacleNumber) {
        return obstacleY[obstacleNumber];
    }
}