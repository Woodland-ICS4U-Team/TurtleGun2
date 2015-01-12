import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class MorePiranhas {
    
    private int PIRANHA_SPAWN_DENSITY = 200;
    private int IMAGE_WIDTH = 50;
    private int IMAGE_HEIGHT = 25;
    private int STARTING_X = TurtleGun2.getLevelWidth();
    private int MAX_STARTING_Y = TurtleGun2.getLevelHeight() - IMAGE_HEIGHT - 80;
    private int MIN_STARTING_Y = 0;
    private int piranhaX;
    private int piranhaY;
    
    private boolean piranhaVisible = false;
    private Image piranhaImage;
    
    private Random number = new Random();
    
    public MorePiranhas() {
        ImageIcon one = new ImageIcon(this.getClass().getResource("Piranha1.png"));
        piranhaImage = one.getImage();
    }
    
    public void spawn() {
        if (!piranhaVisible && number.nextInt(PIRANHA_SPAWN_DENSITY) == 1) {
            System.out.println("spawned");
            piranhaVisible = true;
            piranhaY = number.nextInt(MAX_STARTING_Y - MIN_STARTING_Y) + MIN_STARTING_Y;
            piranhaX = STARTING_X;
        }
    }
    
    public boolean getVisible(){
        return piranhaVisible;
    }
    
    public int getY(){
        return piranhaY;
    }
    
    public int getX(){
        return piranhaX;
    }
    
    public Image getImage(){
        return piranhaImage;
    }
    
    public boolean move(Turtle turtle, Level level) {
        System.out.println("Piranha moved");
        System.out.println("coordinates = " + piranhaX + ", " + piranhaY);
        
        if (piranhaVisible) {
            //add hit detectyion for turtle
            int turtleX = turtle.getX();
            int turtleY = turtle.getY();
            int turtleHeight = turtle.getHeight();
            int turtleWidth = turtle.getWidth();

            boolean hit = false;
            // moves piranha at desired speed
            piranhaX -= 5; 
            if (piranhaX < turtleX + turtleWidth && piranhaX + IMAGE_WIDTH > turtleX) { //If they overlap on X
                if (piranhaY < turtleY + turtleHeight && piranhaY + IMAGE_WIDTH > turtleY) { // If they overlap on Y
                    hit = true; //We hit something
                }

                if (hit) {
                     level.addToInventory();
                     piranhaVisible = false;
                }
                 
                 // if piranha has reached the end of the board without hitting anything, makes it invisible
                if (piranhaX < -20) {
                    piranhaVisible = false;
                }
                return hit;
            }
        } 
        return false;
    }
}