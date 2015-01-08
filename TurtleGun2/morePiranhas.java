import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class morePiranhas {

//----------------------------------------------------------------------------------------
//----------------------------------------variables---------------------------------------
//----------------------------------------------------------------------------------------
    //constants
    private double DIFFICULTY_INCREACE = 0.3;
    private int PIRANHA_PROBABILITY = 1;
    private int NUM_IMAGES = 1;
    private int MAX_PIRANHAS = 2;
    private int MAX_DIFFICULTY = 15;
    //This is the minimum at difficulty 1, but it changes as the difficulty increaces
    private int MIN_PIRANHA_DISTANCE = 400;
    private int PIRANHA_WIDTH = 50;
    private int PIRANHA_HEIGHT = 25;
    private int STARTING_X = TurtleGun2.getLevelWidth();
    private int MAX_STARTING_Y = TurtleGun2.getLevelHeight() - PIRANHA_HEIGHT - 80;
    private int MIN_STARTING_Y = 0;
    
    //piranha arrays
    private Image piranhaImage[] = new Image[MAX_PIRANHAS];
    private int piranhaX[] = new int[MAX_PIRANHAS];
    private int piranhaY[] = new int[MAX_PIRANHAS];
    private double difficulty = 1;
    private boolean piranhaVisible[] = new boolean [MAX_PIRANHAS];
    private boolean piranhaHit[] = new boolean [MAX_PIRANHAS];
    private Image[] piranhaImages = new Image[NUM_IMAGES];
    
    //internal variables
    private Image bloodCloud = (new ImageIcon(this.getClass().getResource("Blood.png"))).getImage();
    private Random number = new Random();

//----------------------------------------------------------------------------------------
//---------------------------------------constructor--------------------------------------
//----------------------------------------------------------------------------------------
 
    public morePiranhas() {
        difficulty = 1;
        ImageIcon one = new ImageIcon(this.getClass().getResource("Piranha1.png"));
        piranhaImages[0] = one.getImage();
    }

//----------------------------------------------------------------------------------------
//-----------------------------------------methods----------------------------------------
//----------------------------------------------------------------------------------------

    public void addPiranha() {
        //When difficulty increaces, the piranhas move closer together and there is a greater chance of them spawning
        for (int i = 0; (i < MAX_PIRANHAS); i ++) {
            if (!piranhaVisible[i]) {
                int x = STARTING_X;
                int y = number.nextInt(MAX_STARTING_Y - MIN_STARTING_Y) + MIN_STARTING_Y;
                if (canPlacePiranha(x, y)) {
                    if (difficulty < MAX_DIFFICULTY) {
                        difficulty += DIFFICULTY_INCREACE;
                    }
                    piranhaVisible[i] = true;
                    piranhaHit[i] = false;
                    piranhaImage[i] = piranhaImages[number.nextInt(NUM_IMAGES)];
                    piranhaY[i] = y;
                    piranhaX[i] = x;
                    return;
                }
            }
        }
    }
    
    public void removePiranha(int piranhaNumber) {
        if ((piranhaNumber >= 0) && (piranhaNumber < MAX_PIRANHAS)) {
            piranhaHit[piranhaNumber] = true;
            piranhaImage[piranhaNumber] = bloodCloud;
        }
    }
    
    public void hidePiranha(int piranhaNumber) {
        if ((piranhaNumber >= 0) && (piranhaNumber < MAX_PIRANHAS)) {
            piranhaVisible[piranhaNumber] = false;
            piranhaHit[piranhaNumber] = true;
        }
    }
    
    public void movePiranhas(int distance) {
        for (int i = 0; i < MAX_PIRANHAS; i ++) {
            if (piranhaVisible[i]) {
                piranhaX[i] -= distance;
                if (piranhaX[i] < -PIRANHA_WIDTH) {
                    piranhaVisible[i] = false;
                }
            }
        }
    }
    
    //Returns -1 if there is not collision, and the object it hit if there is
    public int checkCollisions(int thingX, int thingY, int thingWidth, int thingHeight) {
        for (int i = 0; i < MAX_PIRANHAS; i ++) {
            if (!piranhaHit[i]) {
                if ((piranhaX[i] + 10 < thingX + thingWidth) && (piranhaX[i] - 10 + PIRANHA_WIDTH > thingX)) {
                    if ((piranhaY[i] + 10 < thingY + thingHeight) && (piranhaY[i] - 10 + PIRANHA_WIDTH > thingY)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean canPlacePiranha(int x, int y) {
        if (number.nextInt(PIRANHA_PROBABILITY) == 1) {
            int objX;
            int objY;
            double distance;
            for (int i = 0; i < MAX_PIRANHAS; i++) {
                if (piranhaVisible[i] == true) {
                    objX = piranhaX[i];
                    objY = piranhaY[i];
                    distance = Math.sqrt(Math.pow((objX - x), 2) + Math.pow((objY - y), 2));
                    if (distance < (MIN_PIRANHA_DISTANCE - ((difficulty) * 20))) {
                        return false;
                    }
                }
            }
            System.out.println("can place piranha");
            return true;
        }
        return false;
    }
    
    //Called by the Level class when the game is restarted, so all the variables need to be reset
    public void reset() {
        piranhaImage = new Image[MAX_PIRANHAS];
        piranhaX = new int[MAX_PIRANHAS];
        piranhaY = new int[MAX_PIRANHAS];
        difficulty = 1;
        piranhaVisible = new boolean [MAX_PIRANHAS];
        piranhaHit = new boolean [MAX_PIRANHAS];
        piranhaImages = new Image[NUM_IMAGES];
        difficulty = 1;
        ImageIcon one = new ImageIcon(this.getClass().getResource("Piranha1.png"));
        piranhaImages[0] = one.getImage();
    }
    
//----------------------------------------------------------------------------------------
//------------------------------------getters & setters-----------------------------------
//----------------------------------------------------------------------------------------
    
    public Image getImage(int piranhaNumber) {
        return piranhaImage[piranhaNumber];
    }
    
    public int getNumPiranhas() {
        return MAX_PIRANHAS;
    }
    
    public boolean getVisible(int piranhaNumber) {
        return piranhaVisible[piranhaNumber];
    }
    
    public int getX(int piranhaNumber) {
        return piranhaX[piranhaNumber];
    }
    
    public int getY(int piranhaNumber) {
        return piranhaY[piranhaNumber];
    }
}