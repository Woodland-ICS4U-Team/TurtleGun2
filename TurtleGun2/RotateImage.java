
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;
public class RotateImage extends JPanel  {
    // Declare an Image object for us to use.
    private Image image;
    
    // Create a constructor method
    public RotateImage(){
       super();
       // Load an image to play with.
       image = Toolkit.getDefaultToolkit().getImage("Narwhal.png");
    }
  
    public void paintComponent(Graphics g){
         Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
         g2d.translate(170, 0); // Translate the center of our coordinates.
         g2d.rotate(1);  // Rotate the image by 1 radian.
         g2d.drawImage(image, 0, 0, 200, 200, this);
    }

    public static void main(String arg[]){
       JFrame frame = new JFrame("RotateImage");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(600,400);

       RotateImage panel = new RotateImage();
       frame.setContentPane(panel);  
       frame.setVisible(true);  
    }
}