
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.JButton;
public class Level extends JPanel {

    //----------------------------------------------------------------------------------------
    //----------------------------------------variables---------------------------------------
    //----------------------------------------------------------------------------------------

    private Turtle franklin = new Turtle();
    private Narwhal narwhal = new Narwhal();
    private Obstacle obstacles = new Obstacle();
    private Piranha nemo = new Piranha();
    
    //Images
    private String STARTING_IMAGE_PATH = "Starting Image.jpg";
    private String BACKGROUND_IMAGE_PATH = "Beach pic final 2.jpg";
    private String GAME_OVER_IMAGE_PATH = "Game Over Image.jpg";
    private Image STARTING_IMAGE = (new ImageIcon(this.getClass().getResource(STARTING_IMAGE_PATH))).getImage();
    private Image BACKGROUND_IMAGE = (new ImageIcon(this.getClass().getResource(BACKGROUND_IMAGE_PATH))).getImage();
    private Image GAME_OVER_IMAGE = (new ImageIcon(this.getClass().getResource(GAME_OVER_IMAGE_PATH))).getImage();
    
    //The game modes are 1 for the start screen, 2 for the gameplay, and 3 for the game over screen
    private int gameMode = 1;
    private int levelSpeed = 5;
    private int piranhaSpeed = 12;
    private int levelWidth = 0;
    private int levelHeight = 0;
    private int hitObjectNumber = -1;
    private int width = 0;
    private int height = 0;
    private int shotsLeft = 15;


    //----------------------------------------------------------------------------------------
    //---------------------------------------constructor--------------------------------------
    //----------------------------------------------------------------------------------------
    
    public Level() {
        
        //Create the images
        width = BACKGROUND_IMAGE.getWidth(null);
        height = BACKGROUND_IMAGE.getHeight(null);
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        levelWidth = getWidth();
        levelHeight = getHeight();
        
        //Create the key listener, including the level object
        addKeyListener(new KeyListener(this));
    }
    
    //----------------------------------------------------------------------------------------
    //-----------------------------------------methods----------------------------------------
    //----------------------------------------------------------------------------------------
    
    //This method is called every frame by the level.repaint method in gameTimer
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics = (Graphics2D)g;
        
        switch(gameMode) {
            //The starting screen
            case 1:
                graphics.drawImage(STARTING_IMAGE, 0, 0, this);
                
            
            break;
            
            //The game screen
            case 2:
                
                //The objects are drawn in the order that they should appear on the screen, from bottom to top
                graphics.drawImage(BACKGROUND_IMAGE, 0, 0, this);
                graphics.drawImage(narwhal.getImage(), narwhal.getX(), narwhal.getY(), this);
                graphics.drawString("Piranhas Left: " +  shotsLeft, 10, 10);
                for (int i = 0; i < obstacles.getNumObstacles(); i++) {
                    if (obstacles.getVisible(i)) {
                       graphics.drawImage(obstacles.getImage(i), obstacles.getX(i), obstacles.getY(i), this);
                    }
                }
                
                for (int x = 0; x < nemo.getNumPiranhas(); x++) {
                    if (nemo.getVisible(x)) {
                        graphics.drawImage(nemo.getImage(), nemo.getX(x), nemo.getY(x), this);
                    }
                }
                
                graphics.drawImage(franklin.getImage(), franklin.getX(), franklin.getY(), this);
                
            break;
                
            //The game over screen
            case 3:
            
                graphics.drawImage(GAME_OVER_IMAGE, 0, 0, this);
                
            break;
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    //This method is called every frame by the GameTimer
    public void run() {
        switch(gameMode) {
            
            //Code that is run during the starting screen
            case 1:
            
            break;
            
            //Code that is run during the game screen
            case 2:
                
                //Move all of the objects

                franklin.move();
                narwhal.move();
                nemo.move(piranhaSpeed, obstacles);
                obstacles.addObstacle();
                obstacles.moveObstacles(levelSpeed);
                
                //hitObjectNumber is -1 if nothing was hit, and the object number (0-9) if something was
                hitObjectNumber = obstacles.checkCollisions(franklin.getX() + 10, franklin.getY() + 10, franklin.getWidth() - 20, franklin.getHeight() - 20);
                
                if (hitObjectNumber != -1) {
                    franklin.setLives(franklin.getLives() - 1);
                    obstacles.removeObstacle(hitObjectNumber);
                    if (franklin.getLives() == 0) {
                        gameOver();
                    }
                }
            
            break;
            
            //Code that is run during the game over screen
            case 3:
            
            break;
        }
    }
    
    //Called by the KeyListener class when a key is pressed
    public void keyPressed(int keyCode, Level level) {
        int key = keyCode;
        
        switch(gameMode) {
            
            //When a key is pressed during the starting screen
            case 1:
                
                //Start the game if space is pressed
                if (key == KeyEvent.VK_SPACE) {
                    gameMode = 2;
                }
            
            break;
            
            //When a key is pressed during the game
            case 2:
            
                if (key == KeyEvent.VK_SPACE) {
                    //Add a piranha at the turtle
                    level.addPiranha((franklin.getX() + franklin.getWidth() / 2), franklin.getY() + franklin.getHeight() / 2  - 12);
                    shotsLeft--;
                } else if (key == KeyEvent.VK_LEFT) {
                    //Make the turtle move father up each frame when the left key is pressed
                    franklin.setSpeed(-10);
                } else if (key == KeyEvent.VK_RIGHT) {
                    //Made the turtle move farther down each frame when the right key is pressed
                    franklin.setSpeed(10);
                }
            
            break;
            
            //When a key is pressed during the game over screen
            case 3:
            
                //Go to the start screen if space is pressed
                if (key == KeyEvent.VK_SPACE) {
                    gameMode = 1;
                }
            
            break;
        }

    }
    
    //Called by the KeyListener class when a key is released
    public void keyReleased(int keyCode) {
        int key = keyCode;
        
        switch (gameMode) {
            
            //When a key is released during the game
            case 2:
                
                if ((key == KeyEvent.VK_LEFT) || (key == KeyEvent.VK_RIGHT)) {
                    //Make the turtle stop moving if a left or right key was released
                    franklin.setSpeed(0);
                }
            
            break;
        }
    }
    
    public void addPiranha(int x, int y) {
        nemo.addPiranha(x, y);
    }
    
    
    //Called when the player runs out of lives by the run method
    public void gameOver() {
        gameMode = 3;
        franklin.setLives(3);
        //TODO reset the different variables in all of the classes - They should each have a reset method
    }
  
    //----------------------------------------------------------------------------------------
    //------------------------------------getters & setters-----------------------------------
    //----------------------------------------------------------------------------------------
    
    public int getLevelWidth() {
        return levelWidth;
    }
    public int getShotsLeft() {
        return shotsLeft;
    }
    public int getLevelHeight() {
        return levelHeight;
    }
}
