
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Piranha {
    private String prianhaImage = "Piranha.png";
    private int x, y;
    private Image image;
    boolean visible;
    private int width, height;
    private int MAX_SHOTS = 15;
    private final int BOARD_WIDTH = 1280;
    private final int MISSILE_SPEED = 2;
    private final int piranhaNum = 0;
    private boolean piranhaVisible[] = new boolean[15];
    private Image[] piranhaImages = new Image[15];
    private int piranhaX[] = new int[MAX_SHOTS];
    private int piranhaY[] = new int[MAX_SHOTS];
    private int i = 1;
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

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
    public boolean getVisible(int piranhaNumber) {
        return piranhaVisible[piranhaNumber];
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
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
    public void move() {
        x += MISSILE_SPEED;
        if (x > BOARD_WIDTH)
            visible = false;
    }
}