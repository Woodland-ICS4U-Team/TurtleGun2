import java.awt.Image;
import javax.swing.ImageIcon;

public class Obstacle {
    
    private String image1 = "Narwhal.png";
    private String image2 = "Narwhal.png";
    private String image3 = "Narwal.png";
    private Image image;
    private int objectTable[][];
    
    public Obstacle() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(image1));
        image = ii.getImage();
       // width = image.getWidth(null);
        //height = image.getHeight(null);
     
    }
    
    public Image getImage() {
        return image;
    }
    
    public int getX() {
return 1;
    }
    
    public int getY() {
return 1;
    }
}