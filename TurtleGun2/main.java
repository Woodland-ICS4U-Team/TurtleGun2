
import javax.swing.JFrame;

public class Main extends JFrame{
    
    public Main() {
        add(new Level());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setTitle("Turtle Gun 2");
        setResizable(false);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Main();
        System.out.println("main initiatialezed");
    }
}
