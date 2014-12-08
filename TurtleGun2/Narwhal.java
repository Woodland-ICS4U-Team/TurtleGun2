import java.awt.Image;
import javax.swing.ImageIcon;

public class Narwhal {
    private static int distance;
    private static String narwhalImage = "narwhal.png";
    private static int width;
    private static int height;
    private static int x = 100;
    private static int y = 150;
    private static Image image;

    public Narwhal() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(narwhalImage));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public static Image getImage() {
        return image;
    }
    
    public static int getX() {
        return x;
    }
    
    public static int getY() {
        return y;
    }
    
    public static int getDistance() {
        return distance;
    }
    
}
