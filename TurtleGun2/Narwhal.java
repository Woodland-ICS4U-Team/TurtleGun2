import java.awt.Image;
import javax.swing.ImageIcon;

public class Narwhal {
    private int distance;
    private String narwhalImage = "narwhal.png";
    private int width;
    private int height;
    private int x = 100;
    private int y = 150;
    private int z = 50;
    private Image image;

    public Narwhal() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(narwhalImage));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
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
    
    public int getDistance() {
        return distance;
    }
    public void move() {
        y = (int)(100 * Math.sin(z));
        z++;
        System.out.println("z equals" + z);
    }
}
