
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Piranha {
    private String prianhaImage = "Piranha.png";
    private int x, y;
    private Image image;
    boolean visible;
    private int width, height;
    private int numShots = 15;
    private final int BOARD_WIDTH = 1280;
    private final int MISSILE_SPEED = 2;
    private final int piranhaNum = 0;
    private boolean piranhaVisible[] = new boolean[14];
    private Image[] piranhaImages = new Image[14];
    private int i = 0;
    public Piranha() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(prianhaImage));
        image = ii.getImage();
    }
    public boolean getVisible(int piranhaNumber) {
        return piranhaVisible[piranhaNumber];
    }
    public int getNumPiranahs() {
        return piranhaNum;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public void addPiranha(int x, int y) {
        if (!piranhaVisible[i]) {
            piranhaVisible[i] = true;
        }
    }
    public void move() {
        x += MISSILE_SPEED;
        if (x > BOARD_WIDTH)
            visible = false;
    }
}